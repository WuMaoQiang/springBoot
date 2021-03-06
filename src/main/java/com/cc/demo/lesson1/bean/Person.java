package com.cc.demo.lesson1.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性 映射到这个组件中
 * @ConfigurationProperties ：告诉SpringBoot将本类中所有的属性和配置文件中的相关配置进行绑定
 * prefix= 配置文件中哪个下面的所有属性进行一一映射
 *
 */
@Component
@ConfigurationProperties(prefix ="person" )
//@PropertySource(value = {"classpath:person.properties"}) //加载类路径下的person.properties 并通过ConfigurationProperties绑定person
public class Person {

    private String lastName;
    private Integer age;
    private String sex;
    private Map<String, String> maps;
    private List<String> lists;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}
