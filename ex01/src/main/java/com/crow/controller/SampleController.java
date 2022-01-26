package com.crow.controller;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crow.domain.SampleDTO;
import com.crow.domain.SampleDTOList;
import com.crow.domain.TodoDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    
    public void FormatTest(){
        SimpleDateFormat testDateFormat = new SimpleDateFormat();
        testDateFormat.getTimeInstance();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

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

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {

        log.info("list dtos= " + list);

        return ("ex02Bean");
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {

        log.info("todo: " + todo);

        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {

        log.info("dto: " + dto);
        log.info("page: " + page);

        return "/sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05..........");
    }
    
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        log.info("ex06......");
        SampleDTO dto = new SampleDTO();
        dto.setAge(26);
        dto.setName("Crow");
        
        return dto;
        
    }

}
