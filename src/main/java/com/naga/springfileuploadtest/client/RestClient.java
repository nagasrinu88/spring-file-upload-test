/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.client;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author NavNag
 */
public interface RestClient {

    /**
     * uploads the given file
     *
     * @param filePath
     * @return
     */
    ResponseEntity uploadFile(String filePath);
}
