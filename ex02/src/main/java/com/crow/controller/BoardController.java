package com.crow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crow.domain.BoardVO;
import com.crow.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {

        log.info("controller list");
        model.addAttribute("list", service.getList());

    }
    
    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {

        log.info("controller register: " + board);
        
        service.register(board);
        
        rttr.addFlashAttribute("result", board.getBno());
        
        return "redirect:/board/list";

    }
    
    @GetMapping("/get")
    public void get(@RequestParam("bno") Long bno, Model model) {
        
        
        log.info("BoardController /get");
        model.addAttribute("board", service.get(bno));
    }
    
    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        
        log.info("BoardController modify:" + board);
        
        if(service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
    
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr ) {
        
        log.info("BoardController: remove..." + bno);
        
        if(service.remove(bno)) {
            rttr.addFlashAttribute("reult","success");
        }
        return "/redirect:/board/list";
    }

}
