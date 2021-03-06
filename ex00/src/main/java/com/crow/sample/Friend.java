package com.crow.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Friend {

    @Setter(onMethod_ = { @Autowired})
    private Bear bear;
}
