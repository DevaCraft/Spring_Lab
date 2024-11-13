package com.pdp.oidc.oidc_lab.controller;


import com.pdp.oidc.oidc_lab.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable(required = false) Integer id){
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setErrorHandler(new CustomResponseErrorHandler());
            ResponseEntity<Post> postResponseEntity=  restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",Post.class);
            return ResponseEntity.ok(postResponseEntity.getBody());
    }

}