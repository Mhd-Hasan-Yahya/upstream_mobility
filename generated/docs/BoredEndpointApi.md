# BoredEndpointApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSpecificActivity**](BoredEndpointApi.md#getSpecificActivity) | **GET** /activity | 


<a name="getSpecificActivity"></a>
# **getSpecificActivity**
> String getSpecificActivity(type, participants, price, link, key, accessibility)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BoredEndpointApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    BoredEndpointApi apiInstance = new BoredEndpointApi(defaultClient);
    String type = ""; // String | 
    Integer participants = 56; // Integer | 
    Double price = 3.4D; // Double | 
    String link = ""; // String | 
    String key = ""; // String | 
    Double accessibility = 3.4D; // Double | 
    try {
      String result = apiInstance.getSpecificActivity(type, participants, price, link, key, accessibility);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BoredEndpointApi#getSpecificActivity");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**|  | [optional] [default to ]
 **participants** | **Integer**|  | [optional]
 **price** | **Double**|  | [optional]
 **link** | **String**|  | [optional] [default to ]
 **key** | **String**|  | [optional] [default to ]
 **accessibility** | **Double**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

