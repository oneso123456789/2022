package com.crow.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class SampleHotel {
	private Chef chef;
}