package com.executor;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
public class RequestController {

    @Autowired
    private Test test;



    @RequestMapping(value="/withExecutor", method= RequestMethod.GET)
    public String executeAsync(){

        List<Callable<Integer>> listOfCallable = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3);


        int sum = test.executeAsync(listOfCallable);
        return String.valueOf(sum);
    }
}
