package com.executor;

import com.executor.util.ExecutorServiceConfig;
import com.executor.util.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;



@Component
public class Test {
    public Test() {
    }


    @Autowired
    private Write write;

    @Autowired
    @Qualifier("fixedThreadPool")
    private ExecutorService serviceConfig;

    public  int executeAsync( List<Callable<Integer>> listOfCallable){


        System.out.println(write.write());
        List<Future<Integer>> futures = executeWithResult(listOfCallable);
        int sum = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }).mapToInt(Integer::intValue).sum();

        return sum;
    }


    public  List<Future<Integer>> executeWithResult( List<Callable<Integer>> listOfCallable) {
        try {
            return serviceConfig.invokeAll(listOfCallable);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
