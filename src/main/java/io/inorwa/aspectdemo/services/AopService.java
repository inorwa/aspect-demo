package io.inorwa.aspectdemo.services;

import io.inorwa.aspectdemo.aspect.MeasureTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AopService {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @MeasureTime
    public void directCall(){
        log.info("directCall");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @MeasureTime
    void packageProtectedDirectCall(){
        log.info("protected directCall");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    @MeasureTime
    public void callSubMethod(){
        directCall();
    }
    
    @MeasureTime
    public void callSubMethodProxy(){
        AopService aopService = (AopService)AopContext.currentProxy();
        aopService.directCall();
    }
    
    
}
