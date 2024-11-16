package com.pdp.oidc.oidc_lab.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("rest-test")
    public ResponseEntity<String> getData(){
        String url = "http://httpbin.org/delay/10";  // Delay response by 10 seconds
        String response = null;
        try {
            // Test a delayed response with RestTemplate
            response = restTemplate.getForObject(url, String.class);
            System.out.println("Response: " + response);

        }catch (HttpClientErrorException httpClientErrorException){
            System.out.println(httpClientErrorException.getStatusCode());
        }catch (HttpServerErrorException httpServerErrorException){
            System.out.println(httpServerErrorException.getStatusCode());
        }
        catch (Exception e) {
            // If timeout occurs, handle it here
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
