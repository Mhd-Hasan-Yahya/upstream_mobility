/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BoredEndpointApi
 */
@Ignore
public class BoredEndpointApiTest {

    private final BoredEndpointApi api = new BoredEndpointApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSpecificActivityTest() throws ApiException {
        String type = null;
        Integer participants = null;
        Double price = null;
        String link = null;
        String key = null;
        Double accessibility = null;
                String response = api.getSpecificActivity(type, participants, price, link, key, accessibility);
        // TODO: test validations
    }
    
}