/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naga.springfileuploadtest.client;

/**
 *
 * @author NavNag
 */
public class RestClientBuilder {

    /**
     * Builds a new Rest Client
     *
     * @return
     */
    public static RestClient build() {
        return new RestClientImpl();
    }

}
