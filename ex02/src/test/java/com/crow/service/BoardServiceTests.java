package com.crow.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crow.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = { @Autowired })
    private BoardService service;

    @Test
    public void testExist() {

        log.info(service);
        assertNotNull(service);
        log.info("여기가 로그 끝");
    }

    @Test
    public void testRegister() {

        BoardVO board = new BoardVO();
        board.setTitle("서비스 테스트 작성제목");
        board.setContent("서비스 테스트 작성내용");
        board.setWriter("서비스 테스트 작성자");

        service.register(board);

        log.info("생성된 게시물의 번호: " + board.getBno());
    }

    @Test
    public void testGetList() {

        service.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testGet() {

        log.info(service.get(1L));
    }
    
    @Test
    public void testDelete() {
        
        // 게시물 번호의 존재 여부를 확인하고 테스트 할 것
        log.info("REMOVE RESULT: " + service.remove(2L));
        
    }
    
    @Test
    public void testUpdate() {
        
        BoardVO board = service.get(1L);
        
        // 입력한 번호의 내용이 존재 하지 않으면 리턴을 시킴
        if(board == null) {
            return ;
        }
        
        board.setTitle("서비스 테스트중 제목 수정합니다");
        log.info("MODIFY RESULT: " + service.modify(board));
    }

}
