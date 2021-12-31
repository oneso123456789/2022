package com.crow.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
    
    @Setter(onMethod_ = { @Autowired }) /* @Setter annotation에 사용된 onMethod 속성은 setChef()에 @Autowired annotaion을 추가해줍니다.*/
    private Chef chef;
}
