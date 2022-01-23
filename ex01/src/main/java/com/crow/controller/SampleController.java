package com.crow.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crow.domain.SampleDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @RequestMapping("test")
    public void basic() {
        log.info("basic .........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        /*
         * dto.setAge(26); dto.setName("crow");
         */

        log.info("" + dto);

        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        
        log.info("name= " + name);
        log.info("age= " + age);
        
        return "ex02";
    }
    
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        
        log.info("ids = " + ids);
        
        return "exo2List";
    }
    
    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {
        
        log.info("ids = " + Arrays.toString(ids)); 
        
        return "ex02Array";
    }

}
