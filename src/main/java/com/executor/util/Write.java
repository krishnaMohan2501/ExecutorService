package com.executor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Write {

    @Autowired
    private Test1 test1;

    public String write(){
        return test1.test();
    }
}
