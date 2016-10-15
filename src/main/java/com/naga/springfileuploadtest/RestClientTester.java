/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest;

import com.naga.springfileuploadtest.client.RestClient;
import com.naga.springfileuploadtest.client.RestClientBuilder;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author NavNag
 */
public class RestClientTester {

    public static void main(String[] args) {
        // Replace the path with the properfile that want to be uploaded
        String file = "D:\\Projects\\SpringFileUploadTest\\src\\main\\webapp\\index.html";
        RestClient client = RestClientBuilder.build();
        ResponseEntity response = client.uploadFile(file);
        System.out.println("Upload Response= " + response);
    }
}
