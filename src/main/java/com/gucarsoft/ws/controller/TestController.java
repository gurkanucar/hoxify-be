package com.gucarsoft.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/secured")
    String secure(){
        return "secured place";
    }

}
