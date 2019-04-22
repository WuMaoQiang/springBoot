package com.cc.demo.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        List<Map<String, String>> listInfo = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            Map<String, String> map = new HashMap<>();
            map.put("name", "" + lo.get(0));
            map.put("age", "" + lo.get(1));
            map.put("sex", "" + lo.get(2));
            map.put("personid", "" + lo.get(3).toString().substring(0, lo.get(3).toString().indexOf(".")));
            listInfo.add(map);
        }
        Map<String, Object> returMap = new HashMap<>();
        returMap.put("data", listInfo);
        returMap.put("msg", "成功");
        return returMap;
    }
}