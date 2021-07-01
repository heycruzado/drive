package com.alex.drive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ExampleController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello/{param}")
    public String helloWorldWithParam(@PathVariable("param") String param){
        return "Hello world with: "+param;
    }

    @PostMapping("/hello")
    public ResponseEntity<String> createPerson(@RequestBody String person){
        return ResponseEntity.status(HttpStatus.OK).body("The person "+person+" was created :D");
    }
}
