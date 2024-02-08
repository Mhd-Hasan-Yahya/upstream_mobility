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

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoredEndpointApi {
    private ApiClient localVarApiClient;

    public BoredEndpointApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BoredEndpointApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getSpecificActivity
     * @param type  (optional, default to )
     * @param participants  (optional)
     * @param price  (optional)
     * @param link  (optional, default to )
     * @param key  (optional, default to )
     * @param accessibility  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSpecificActivityCall(String type, Integer participants, Double price, String link, String key, Double accessibility, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/activity";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (type != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("type", type));
        }

        if (participants != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("participants", participants));
        }

        if (price != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("price", price));
        }

        if (link != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("link", link));
        }

        if (key != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("key", key));
        }

        if (accessibility != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("accessibility", accessibility));
        }

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getSpecificActivityValidateBeforeCall(String type, Integer participants, Double price, String link, String key, Double accessibility, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = getSpecificActivityCall(type, participants, price, link, key, accessibility, _callback);
        return localVarCall;

    }

    /**
     * 
     * 
     * @param type  (optional, default to )
     * @param participants  (optional)
     * @param price  (optional)
     * @param link  (optional, default to )
     * @param key  (optional, default to )
     * @param accessibility  (optional)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public String getSpecificActivity(String type, Integer participants, Double price, String link, String key, Double accessibility) throws ApiException {
        ApiResponse<String> localVarResp = getSpecificActivityWithHttpInfo(type, participants, price, link, key, accessibility);
        return localVarResp.getData();
    }

    /**
     * 
     * 
     * @param type  (optional, default to )
     * @param participants  (optional)
     * @param price  (optional)
     * @param link  (optional, default to )
     * @param key  (optional, default to )
     * @param accessibility  (optional)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<String> getSpecificActivityWithHttpInfo(String type, Integer participants, Double price, String link, String key, Double accessibility) throws ApiException {
        okhttp3.Call localVarCall = getSpecificActivityValidateBeforeCall(type, participants, price, link, key, accessibility, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param type  (optional, default to )
     * @param participants  (optional)
     * @param price  (optional)
     * @param link  (optional, default to )
     * @param key  (optional, default to )
     * @param accessibility  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getSpecificActivityAsync(String type, Integer participants, Double price, String link, String key, Double accessibility, final ApiCallback<String> _callback) throws ApiException {

        okhttp3.Call localVarCall = getSpecificActivityValidateBeforeCall(type, participants, price, link, key, accessibility, _callback);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}