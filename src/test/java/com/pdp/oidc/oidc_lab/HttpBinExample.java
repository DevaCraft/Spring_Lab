package com.pdp.oidc.oidc_lab;

import org.springframework.web.client.RestTemplate;

public class HttpBinExample {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://httpbin.org/delay/10";  // Delay response by 10 seconds

        try {
            // Test a delayed response with RestTemplate
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            // If timeout occurs, handle it here
            System.out.println("Error: " + e.getMessage());
        }
    }
}
