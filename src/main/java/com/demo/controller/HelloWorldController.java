package com.demo.controller;
 
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Employee;
import com.demo.mapper.DataMapper;
 
@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {
	
	private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    DataMapper dataMapper;
 
    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser( ){
    	logger.debug("进入方法");
    	logger.debug("方法结束");
        return dataMapper.test_query(1);
    }
    @RequestMapping("/employee")
    public String employee(Map<String,Object> map) {
    	List<Employee>  emps=dataMapper.test_query(1);
    	map.put("employees", emps);
    	return "employee";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
    	return "hello,nihao aa";
    }
}