/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author NavNag
 */
@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOG = Logger.getLogger(FileServiceImpl.class.getName());

    // defaul buffer size is 10 KB
    private static final int BUFFER_SIZE = 10 * 1024;

    @Override
    public boolean saveFile(String fileName, InputStream stream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        OutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            int readed;
            while ((readed = stream.read(buffer)) != -1) {
                LOG.log(Level.INFO, "{0} bytes readed from input file", new Object[]{readed});
                out.write(buffer);
                LOG.log(Level.INFO, "{0} bytes written to file {1}", new Object[]{readed, fileName});
            }
            return true;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Unable to save the file {0} reason {1}", new Object[]{fileName, e});
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return false;
    }
}
