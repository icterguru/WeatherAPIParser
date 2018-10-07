package parserClasses;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

//@SuppressWarnings("deprecation")
public class RESTfulAPIOperations {

	public static String restful_GET_Operation(String requestUrl) throws Exception {
		String restGETResponse;
		try {
			@SuppressWarnings("resource")
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(requestUrl);
			getRequest.setHeader("Content-Type", "application/json");
			getRequest.setHeader("Accept", "application/json");
			
			HttpResponse response = httpClient.execute(getRequest);
			int errorCode = response.getStatusLine().getStatusCode();
			if (errorCode == 200) {
				restGETResponse = EntityUtils.toString(response.getEntity());
			} else {
				throw new RuntimeException("RESTful Get operation Failed : error code : " + errorCode);
			}
			httpClient.getConnectionManager().shutdown();
		}catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}		
		System.out.println("restGETResponse:: "+ restGETResponse);
		return restGETResponse;
	}
	
	public static String restful_POST_Operation(String requestUrl, String authCode, JSONObject jsonBody) throws Exception {

		String restPOSTResponse = null;
		try {
			@SuppressWarnings("resource")
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(requestUrl);
			postRequest.setHeader("Content-Type", "application/json");
			postRequest.addHeader("charset", "UTF-8");
			postRequest.setHeader("Accept", "application/json");
			postRequest.setHeader("Authorization", authCode);
			StringEntity inputData = new StringEntity(jsonBody.toString());
			postRequest.setEntity(inputData);
			HttpResponse response = httpClient.execute(postRequest);
			int errorCode = response.getStatusLine().getStatusCode();
			if (errorCode == 200) {
				restPOSTResponse = EntityUtils.toString(response.getEntity());
			} else {
				throw new RuntimeException("RESTful Post operation Failed : error code : " + errorCode);
			}
			httpClient.getConnectionManager().shutdown();
		}catch (Exception e) {
			e.printStackTrace();
			throw(e);
		}
		return restPOSTResponse;
	}


}