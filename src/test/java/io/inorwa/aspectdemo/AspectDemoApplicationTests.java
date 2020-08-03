package io.inorwa.aspectdemo;

import io.inorwa.aspectdemo.services.AopService;
import io.inorwa.aspectdemo.services.HelpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AspectDemoApplicationTests {
    
    @Autowired
    AopService aopService;
    
    @Autowired
    HelpService helpService;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    void testAspects(){
        aopService.directCall();
        aopService.callSubMethod();
        aopService.callSubMethodProxy();
        helpService.callAopService();
    }
    
}
