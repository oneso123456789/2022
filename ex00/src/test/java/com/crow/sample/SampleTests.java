package com.crow.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) /* @Runwith annotation은 테스트 코드가 스프링을 실행하는 역활이란것을 표시해줌 */
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") /*
                                                                               * @ContextConfiguration은 지정 클래스나 문자열을 이용
                                                                               * 필요한 객체들을 스프링 bean으로 등록
                                                                               */
@Log4j
public class SampleTests {
    
    /* @Autowired는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해달라는 표시 이 코드에서 정상적으로 주입이 가능할시 obj 변수에
     * Restaurant 타입의 객체를 주입 */
    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;
    @Setter(onMethod_ = { @Autowired })
    private Friend friend;
    
    
    /* @Test는 JUnit에서 테스트 대상을 표시하는 annotation 해당 메서드를 선택하고 JUnit Test 기능을 실행*/
    @Test
    public void testExist() {
        
    /* assertNotNull()은 restaurant변수가 Null이 아니여야만 테스트를 성공하는걸 의미
     * 테스트 작업은 프로젝트 초기에 설정해 두고 사용하는 습관을 가져야함 */    
        assertNotNull(restaurant);
        
        log.info(restaurant);
        log.info("---------------------");
        log.info(restaurant.getChef());
        
    }
    
    @Test
    public void test1(){
        assertNotNull(friend);
        
        log.info(friend);
        log.info("곰은 친구라구욧");
        
    }

}
