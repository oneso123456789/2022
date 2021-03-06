package com.crow.mapper;

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
public class BoardMapperTests {

    @Setter(onMethod_ = { @Autowired })
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("testInsert문 제목이라구");
        board.setContent("testInsert문 내용이라구");
        board.setWriter("testInsert문 작성자라구");

        mapper.insert(board);

        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글 select key");
        board.setContent("새로 작성하는 내용 select key");
        board.setWriter("새로작성하는 이용자");

        mapper.insertSelectKey(board);

        log.info(board);

    }

    @Test
    public void testRead() {
        // 존재하는 게시물 번호로 테스트
        BoardVO board = mapper.read(4L);

        log.info(board);
    }

    @Test
    public void testDelete() {

        log.info("DELETE COUNT: " + mapper.delete(3L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("update제목");
        board.setContent("update내용");
        board.setWriter("update작성자");

        int count = mapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }

}
