package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.domain.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckService {

    @Autowired
    private HttpCallService httpCall;

    public List getHistToryStep(String instId){
        String result = httpCall.historyList(instId);
        List list = JSONArray.parseArray(result);
        return list;
    }

    public Map getCurrentStep(String instId){
        String result = httpCall.currentStep(instId);
        List list = JSONArray.parseArray(result);
        Map map = new HashMap();
        if(list.size()>0){
            map = JSON.parseObject(list.get(0).toString());
        }

        return map;
    }

    public String getReasonByInstId(int instId, String formField){
        String result = httpCall.getFormFiled(formField, instId);

        String reason ="";
        try {
            Map map = JSON.parseObject(result);
            List<Map> list = (List<Map>)map.get("formPropertyValues");
            reason = list.get(1).get("value").toString();
        }catch (Exception x){

        }
        return reason;
    }

    public String clickCheck(String checkName,String nextCheckName,int instId,String suggest){
        //根据instId获取activeStepId

        String result = httpCall.getActiveStepIdByInstId(instId);
        List list = JSONArray.parseArray(result);
        int activeStepId = 1;
        String stepId = "qjt.2";
        if(list.size()>0){
            Map map = JSON.parseObject(list.get(0).toString());
            activeStepId = Integer.parseInt(map.get("id").toString());
            stepId = map.get("stepId").toString();
        }
        //推动流程

        String[] stepArray = stepId.split(".");
        String nextStepId = "qjt.3";
        try{
            int num = Integer.parseInt(stepArray[1])+1;
            nextStepId = stepArray[0]+num;
        }catch (Exception x){

        }
        String instIdArray = httpCall.pushProcess(checkName,nextCheckName,instId,activeStepId,stepId,nextStepId,suggest);

        return instIdArray;

    }

    public List getSuggest(String beanId){
       String result =  httpCall.getSuggest(beanId, "model%3A_102411");
        List<Map> suggestList = new ArrayList();
        try {
            Map resultMap = JSON.parseObject(result);
            List<Map> list = (List<Map>)resultMap.get("opinion");

            for(Map map : list){
                String suggest = map.get("content").toString();
                String[] dates=suggest.split("<date>|</date>");
                String date = dates[1];

                String[] users=suggest.split("<user>|</user>");
                String user = users[1];

                String[] contents=suggest.split("<content>|</content>");
                String content = contents[1];

                Map suggestMap = new HashMap();
                suggestMap.put("date",date);
                suggestMap.put("user",user);
                suggestMap.put("content",content);
                suggestList.add(suggestMap);
            }
        }catch (Exception x){

        }
       return suggestList;
    }
}
