package com.jacliu.test.apacheHttpclients;

import cn.hutool.core.map.MapUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.print.URIException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpTest {
    public static void main(String[] args) {

        RequestConfig requestConfig = getRequestConfig(2000,3000,5000);
        String urlPrefix = "";
        String urlCommand = "";
        HashMap<Object, Object> reqParam = MapUtil.of(new String[][]{{"head", ""}, {"body", ""}});
        Map headerMap = MapUtil.of("aaa","bbb");

        // get请求【请求地址+参数+请求头+超时时间;+返回数据格式化】
        String getResult = doGet(requestConfig,urlPrefix,urlCommand,reqParam,headerMap);

        String postResult = doPost(requestConfig,urlPrefix,urlCommand,reqParam,headerMap);



        String authResutlt = doAuth();
    }

    private static String doAuth() {
        String result = null;
        HttpGet request = new HttpGet("http://localhost:8080/books");

        HttpHost target = new HttpHost("localhost", 8080, "http");
        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("user", "password")
        );

        AuthCache authCache = new BasicAuthCache();
        authCache.put(target, new BasicScheme());

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();
             CloseableHttpResponse response = httpClient.execute(target, request, localContext)) {

            // 401 if wrong user/password
            System.out.println(response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                switch (result = EntityUtils.toString(entity)) {
                }
                System.out.println(result);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String doPost(RequestConfig requestConfig, String urlPrefix, String urlCommand, HashMap<Object, Object> reqParam, Map headerMap) {
        String result = null;

        try {
            URIBuilder uriBuilder = new URIBuilder(urlPrefix + urlCommand);
            HttpPost httpPost = new HttpPost();
            httpPost.setConfig(requestConfig);
            headerMap.keySet().stream().forEach(key->{
                httpPost.setHeader(key.toString(),headerMap.get(key).toString());
            });
            // 组装请求参数。
            List<BasicNameValuePair> basicNameValuePairs = reqParam.keySet().stream().map(key -> {
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key.toString(), reqParam.get(key).toString());
                return basicNameValuePair;
            }).collect(Collectors.toList());
            // UrlEncodedFormEntity 表单请求 【还有 json inputStream等。】
            httpPost.setEntity(new UrlEncodedFormEntity(basicNameValuePairs));
            //httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

            CloseableHttpClient aDefault = HttpClients.createDefault();
            CloseableHttpResponse execute = aDefault.execute(httpPost);

            if(execute.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(execute.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String doGet(RequestConfig requestConfig, String urlPrefix, String urlCommand, Map reqParam, Map headerMap) {
        String result = null;
        // 1：根据请求地址及参数创建具体的请求URI
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(urlPrefix + urlCommand);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        URIBuilder finalUriBuilder = uriBuilder;
        reqParam.keySet().stream().forEach(key->{
            finalUriBuilder.addParameter(key.toString(),reqParam.get(key).toString());
        });
        URI uri = null;
        try {
            uri = finalUriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        // 2：根据URI创建httpGet 及 控制超时设置 及 请求头之类的配置
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setConfig(requestConfig);
        headerMap.keySet().stream().forEach(key->{
            httpGet.addHeader(key.toString(),headerMap.get(key).toString());
        });

        // 3：创建httClients对象并
        CloseableHttpClient defaultHttp = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = defaultHttp.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4：获取返回值
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200){
            try {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static RequestConfig getRequestConfig(int socketTimeOut, int connectTimeout,int connectionRequestTimeout) {
        return RequestConfig.custom()
                    .setSocketTimeout(socketTimeOut) //服务器响应超时时间
                    .setConnectTimeout(connectTimeout) //连接服务器超时时间
                    .setConnectionRequestTimeout(connectionRequestTimeout) // 连接超时时间
                    .build();
    }
}
