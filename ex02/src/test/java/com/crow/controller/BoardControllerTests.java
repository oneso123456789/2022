package com.crow.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//Test for Controller
@WebAppConfiguration
@ContextConfiguration({
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {

    @Setter(onMethod_ = { @Autowired })
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {

        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn()
                .getModelAndView()
                .getModelMap());
    }
    
    @Test
    public void testRegister() throws Exception{
        
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "BoardControllerTests 제목2")
                .param("content","BoardControllerTests 내용2" )
                .param("writer", "BoardControllerTests 작성자2")
                ).andReturn().getModelAndView().getViewName();
        
        log.info("BoardController log " + resultPage );
    }
    
    @Test
    public void testGet() throws Exception{
        
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
                .param("bno", "51"))
                .andReturn()
                .getModelAndView().getModelMap());
    }
    
    @Test
    public void testModify() throws Exception{
        
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno", "4")
                .param("title", "제목 BoardControllerTests중 수정됨")
                .param("content", "내용 BoardControllerTests중 수정됨")
                .param("writer", "작성자 BoardControllerTests중 수정됨"))
                .andReturn().getModelAndView().getViewName();
        
        log.info("BoardControllerTests " + resultPage);
    }
    
    @Test
    public void testRemove() throws Exception {
        // 삭제전 데이터 베이스 게시물 번호 확인
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "5"))
                .andReturn().getModelAndView().getViewName();
        
        log.info("BoardControllerTests: " + resultPage);
        
    }
    
}
