/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.client;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author NavNag
 */
public class RestClientImpl implements RestClient {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String API_URL = BASE_URL + "/api/v1";

    /**
     * Package scoped constructor
     */
    RestClientImpl() {
    }

    /**
     * Internal rest template builder
     *
     * @return
     */
    private RestTemplate buildTemplate() {
        return new RestTemplate();
    }

    @Override
    public ResponseEntity uploadFile(String filePath) {
        Resource resource = new FileSystemResource(filePath);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        //parts.add("Content-Type", "image/jpeg");
        parts.add("file", resource);

        return buildTemplate().exchange(API_URL + "/file", HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, Object>>(parts),
                String.class);
    }

}
