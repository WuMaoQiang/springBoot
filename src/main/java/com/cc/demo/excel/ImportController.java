package com.cc.demo.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ImportController {
    List<bean> listInfo2;
    @Autowired
    private ImportService importService;


    @PostMapping(value = "/upload")
    @ResponseBody
    public Map<String, Object> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return null;
        }
        InputStream inputStream = file.getInputStream();
        //读取文件 返回list数据
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        //将list数据转换成自己想要的listMap形式
        List<bean> listInfo = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            bean mybean = new bean();
            mybean.setName("" + lo.get(0));
            mybean.setAge("" + lo.get(1));
            mybean.setSex("" + lo.get(2));
            mybean.setPersonid("" + lo.get(3).toString().substring(0, lo.get(3).toString().indexOf(".")));
            listInfo.add(mybean);
        }
        Map<String, Object> returMap = new HashMap<>();
        returMap.put("data", listInfo);
        returMap.put("msg", "成功");
        return returMap;
    }

    /**
     * 获取所有数据列表 页面
     *
     * @param file
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/uploadweb")
//    @ResponseBody 去掉@ResponseBody ，不然返回的不是templates下的excel
    public String uploadWebExcel(@RequestParam("file") MultipartFile file, Model model) throws Exception {
        if (file.isEmpty()) {
            return null;
        }
        InputStream inputStream = file.getInputStream();
        //读取文件 返回list数据
        List<List<Object>> list2 = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        //将list数据转换成自己想要的listMap形式
        listInfo2 = new ArrayList<>();
        for (int i = 0; i < list2.size(); i++) {
            List<Object> lo = list2.get(i);
            bean mybean = new bean();
            mybean.setName("" + lo.get(0));
            mybean.setAge("" + lo.get(1));
            mybean.setSex("" + lo.get(2));
            mybean.setPersonid("" + lo.get(3).toString().substring(0, lo.get(3).toString().indexOf(".")));
            listInfo2.add(mybean);
        }


        model.addAttribute("emps", listInfo2);

        return "excel";
    }

    /**
     * 获取数据列表
     */
    @GetMapping(value = "/emps")
    public String getList(Model model) {

        model.addAttribute("emps", listInfo2);
        return "list";
    }

    /**
     * 来到添加页面
     */
    @GetMapping(value = "/emp")
    public String toAddPage() {
        return "add";
    }

    /**
     * 添加用户功能
     *
     * @return
     */
    @PostMapping(value = "/emp")
    public String addEmp(bean map) {
        listInfo2.add(map);
        return "redirect:/emps";
    }

    /**
     * 来到编辑页面（添加编辑二合一）
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/emp/{id}")
    public String editEmp(@PathVariable(value = "id") String id, Model model) {
        bean which = null;
        for (int i = 0; i < listInfo2.size(); i++) {
            bean bean = listInfo2.get(i);
            if (id.equals(bean.getPersonid())) {
                which = bean;
            }
        }
        model.addAttribute("emp", which);


        return "add";
    }

    /**
     * 编辑功能
     *
     * @return
     */
    @PutMapping(value = "/emp")
    public String putEmp(bean map) {

        String personid = map.getPersonid();
        for (int i = 0; i < listInfo2.size(); i++) {
            bean bean = listInfo2.get(i);
            if (personid.equals(bean.getPersonid())) {
                listInfo2.remove(i);
                listInfo2.add(i, map);
            }
        }
        return "redirect:/emps";
    }


    /**
     * 删除功能
     *
     * @return
     */
    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable(value = "id") String id) {

        for (int i = 0; i < listInfo2.size(); i++) {
            bean bean = listInfo2.get(i);
            if (id.equals(bean.getPersonid())) {
                listInfo2.remove(i);
            }
        }
        return "redirect:/emps";
    }

}