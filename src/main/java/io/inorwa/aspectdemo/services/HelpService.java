package io.inorwa.aspectdemo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelpService {
    private final AopService aopService;
    
    public void callAopService(){
        aopService.packageProtectedDirectCall();
    }
}
