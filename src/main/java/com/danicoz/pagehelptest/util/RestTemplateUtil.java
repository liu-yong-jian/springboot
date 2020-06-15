package com.danicoz.pagehelptest.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.net.URI;
//https://blog.csdn.net/smd2575624555/article/details/78975336?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
//https://blog.csdn.net/keehom/article/details/80721599
public class RestTemplateUtil {

    private static SimpleClientHttpRequestFactory requestFactory;
    static{
        requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(180000);// 设置超时
        requestFactory.setReadTimeout(180000);
    }

    /**
     * post 请求
     * @param value
     * @param URL
     * @return
     */
    public static JSONObject post(final Object value, final String URL) {

        if (!StringUtils.isNotBlank(URL)) {
            return null;

        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String requestJson = null;
        try {
            requestJson = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Charset", "utf-8");
        headers.set("Content-type", "text/xml; charset=utf-8");// 设置编码
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
        Integer code = response.getStatusCode().value();
        if (200 != code) {
            //错误返回值处理
        }

        JSONObject body = new JSONObject().parseObject(response.getBody());
        return body;
    }


    /**
     *      * get请求封装
     *      *
     *      * @param uriComponents
     *      * @return
     *      
     */

    public static JSONObject get(final UriComponents uriComponents) {

        if (null == uriComponents) {
            return null;

        }
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        URI uri = uriComponents.toUri();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Integer code = response.getStatusCode().value();
        if (200 != code) {
            //错误返回值处理
        }

        JSONObject body = new JSONObject().parseObject(response.getBody());
        return body;

    }
//
//    /**
//      * delete请求封装
//      *
//      * @param URL
//      * @param map
//      * @return
//      */
//
//            public static JSONObject delete(final String URL,final  Map<String, Object> map) {
//
//        if (!StringUtils.isNotBlank(URL)) {
//
//            return null;
//
//        }
//
//        log.info("URL:{}", URL);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(180000);// 设置超时
//        requestFactory.setReadTimeout(180000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.DELETE, entity, String.class, map);
//        Integer code = response.getStatusCode().value();
//
//        if (200 != code) {
//
//           //错误返回值处理
//
//        }
//        JSONObject body = new JSONObject().parseObject(response.getBody());
//        log.info("body:{}", body);
//        return body;
//
//    }


}
