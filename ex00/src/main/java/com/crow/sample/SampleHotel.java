package com.crow.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {
    
    private Chef chef;
    
    /*
     * public SampleHotel(Chef chef) {
     * 
     * this.chef = chef;
     * 
     * }
     */
}
