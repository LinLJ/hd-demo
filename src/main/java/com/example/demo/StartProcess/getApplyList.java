package com.example.demo.StartProcess;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.example.demo.utils.MapToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class getApplyList {
    @Autowired
    private DoPostJson postJson;
    @Autowired
    private MapToString mts;

    public String applyList(String hdId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/user-tasks/application";
        Map<String,String> map = new HashMap<String,String>();
        String json = "{\"userAccount\": \""+hdId+"\"}";
        String result ="";
        try {
            result = postJson.getPostJson(url,json);
        }catch (Exception e){
        }
        return result;
    }

    public String checkList(String hdId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/user-tasks/todo";
        Map<String,String> map = new HashMap<String,String>();
        String json = "{\"maxResults\":100,\"userAccount\": \""+hdId+"\"}";
        String result ="";
        try {
            result = postJson.getPostJson(url,json);
        }catch (Exception e){
        }
        return result;
    }
}
