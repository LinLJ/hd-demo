package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.StartProcess.DoPostJson;
import com.example.demo.domain.FlowProcess;
import com.example.demo.domain.PushProcess;
import com.example.demo.domain.UserRepository;
import com.example.demo.parameter.StartProcessParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HttpCallService {


    @Autowired
    private DoPostJson postJson;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StartProcessParameter startProcessParameter;

    /**
     * 获取历史流转过程
     * @param instId
     * @return
     */
    public String historyList(String instId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-tracing/history-steps/"+instId;
        Map<String,String> map = new HashMap<String,String>();
        String result ="";
        try {
            result = postJson.doGet(url,null);
        }catch (Exception e){
        }
        return result;
    }

    /**
     * 获取当前流转情况
     * @param instId
     * @return
     */
    public String currentStep(String instId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-tracing/current-steps/"+instId;
        Map<String,String> map = new HashMap<String,String>();
        String result ="";
        try {
            result = postJson.doGet(url,null);
        }catch (Exception e){
        }
        return result;
    }

    public String getActiveStepIdByInstId(int instId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-instance-query/active-steps/"+instId;
        Map<String,String> map = new HashMap<String,String>();
        String result ="";
        try {
            result = postJson.doGet(url,null);
        }catch (Exception e){
        }
        return result;
    }

    public String getSuggest(String beanId,String formId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-instance-query/all-opinion/"+formId+"/"+beanId;
        Map<String,String> map = new HashMap<String,String>();
        String result ="";
        try {
            result = postJson.doGet(url,null);
        }catch (Exception e){
        }
        return result;
    }


    public String pushProcess(String userName, String checkName, int instId, int activeStepId,String stepId, String nextStepId,String suggest){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-drive/task/dispatch";
        Map<String,String> map = new HashMap<String,String>();
        String userHdId = userRepository.findHdIdByUserName(userName);
        String checkHdId = userRepository.findHdIdByUserName(checkName);

        Map caller = startProcessParameter.getStartCaller(userHdId,userName);
        List<Map> particpantInfos = startProcessParameter.getStartParticipantInfos(checkHdId,checkName,nextStepId);
        List<Map> opinions = startProcessParameter.getStartOpinions(suggest);

        PushProcess pushProcess = new PushProcess();
        pushProcess.setActionId(stepId);
        pushProcess.setCaller(caller);
        pushProcess.setFormId("model:_102411");
        pushProcess.setInstId(instId);
        pushProcess.setParticipantInfos(particpantInfos);
        pushProcess.setActiveStepId(activeStepId);
        pushProcess.setOpinions(opinions);

        String json = JSONObject.toJSON(pushProcess).toString();


        String result ="";
        try {
            result = postJson.getPostJson(url,json);
        }catch (Exception e){
        }
        return result;
    }

    public String getFormFiled(String formField, int instId){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-manager/process-instance/form-data";
        Map<String,String> map = new HashMap<String,String>();
        String json = "{\"includeFields\": \""+formField+"\",\"instId\":\""+instId+"\",\"thirdBeanTitleProperty\":\"title\"}";
        String result ="";
        try {
            result = postJson.getPostJson(url,json);
        }catch (Exception e){
        }
        return result;
    }

}
