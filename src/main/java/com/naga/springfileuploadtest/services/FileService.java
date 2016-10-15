/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.services;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author NavNag
 */
public interface FileService {

    boolean saveFile(String fileName, InputStream stream) throws IOException;
}
