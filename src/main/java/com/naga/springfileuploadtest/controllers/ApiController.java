/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.controllers;

import com.naga.springfileuploadtest.services.FileService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NavNag
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private static final Logger LOG = Logger.getLogger(ApiController.class.getName());
    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        ResponseEntity response;
        LOG.log(Level.INFO, "Trying to upload file {0}", file.getName());
        if (fileService.saveFile(System.currentTimeMillis() + "-" + file.getOriginalFilename(), file.getInputStream())) {
            response = new ResponseEntity(HttpStatus.CREATED);
        } else {
            response = new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
        return response;
    }
}
