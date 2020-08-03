package io.inorwa.aspectdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping(value = "simple")
    public ResponseEntity<String> simple(){
         return ResponseEntity.ok("OK");
    }
}
