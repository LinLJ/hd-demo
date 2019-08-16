package com.example.demo.StartProcess;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.FlowProcess;
import com.example.demo.domain.UserRepository;
import com.example.demo.parameter.StartProcessParameter;
import com.example.demo.utils.MapToString;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StartProcess {

    @Autowired
    private DoPostJson postJson;
    @Autowired
    private MapToString mts;
    @Autowired
    private StartProcessParameter startProcessParameter;
    @Autowired
    private UserRepository userRepository;

    public String startApply(String userName, String checkName, String reason){
        String url="http://192.168.70.47:8888/grcv5/api/flow/v1/process-drive/process-instance/start_dispatch";
        Map<String,String> map = new HashMap<String,String>();
        String userHdId = userRepository.findHdIdByUserName(userName);
        String checkHdId = userRepository.findHdIdByUserName(checkName);

        Map caller = startProcessParameter.getStartCaller(userHdId,userName);
        List<Map> inputs = startProcessParameter.getStartInputs(userName, reason);
        List<Map> particpantInfos = startProcessParameter.getStartParticipantInfos(checkHdId,checkName,"qjt.2");


        FlowProcess flowProcess = new FlowProcess();
        flowProcess.setActionId("qjt.1");
        flowProcess.setCaller(caller);
        flowProcess.setFlowId("qjt");
        flowProcess.setFormId("model:_102411");
        flowProcess.setInputs(inputs);
        flowProcess.setParticipantInfos(particpantInfos);

        String json = JSONObject.toJSON(flowProcess).toString();


        String result ="";
        try {
            result = postJson.getPostJson(url,json);
        }catch (Exception e){
        }
        return result;
    }

    /*public void testStartProcess(){

        // json 解析 工具类初始化
        ObjectMapper objectMapper = new ObjectMapper();
        // Include.NON_NULL 属性为NULL 不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        SimpleModule module = new SimpleModule();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.registerModule(module);

        // 发起获取流程定义rest接口URL
        String startFlowRest = "http://192.168.70.47:8888/grcv5/api/flow/v1/process-drive/process-instance/start";

        // 构建发起流程rest接口参数
        JsonObject restParam = new JsonObject();
        restParam.addProperty("flowId", "qjt");//设置流程ID ，所调用的流程

        restParam.addProperty("formId", "model:_102411");//设置流程所使用的表单ID，流程所调用平台表单

        restParam.addProperty("actionId", "qjt.1");//设置执行的操作ID

        //构建调用者
        JsonObject caller = new JsonObject();
        caller.addProperty("userAccount", "102404");//设置调用者账户
        caller.addProperty("userName", "c1");//设置调用者名称
        restParam.add("caller", caller);//设置执行的操作ID

        //构建表单属性值
        JsonArray inputs =new JsonArray();

        JsonObject title = new JsonObject();
        title .addProperty("name", "title");//设置表单属性ID
        title.addProperty("value", "llj的请假条"+new DateTime().toString());//设置表单属性值
        inputs.add(title);

        JsonObject shenqingren = new JsonObject();
        shenqingren .addProperty("name", "shenqingren2");//设置表单属性ID
        shenqingren.addProperty("value", "llj"+new DateTime().toString());//设置表单属性值
        inputs.add(shenqingren);

        JsonObject yuanyin = new JsonObject();
        yuanyin .addProperty("name", "yuanyin2");//设置表单属性ID
        yuanyin.addProperty("value", "请假"+new DateTime().toString());//设置表单属性值
        inputs.add(yuanyin);

        restParam.add("inputs", inputs);


        //构建表单意见
        JsonArray opinions =new JsonArray();
        JsonObject opinion = new JsonObject();
        opinion .addProperty("name", "sxmz2");//设置表单属性ID
        opinion.addProperty("value", "标题测试1-办公用品报销"+System.currentTimeMillis());//设置表单属性值
        opinions.add(opinion);

        restParam.add("opinions", opinions);

        // 构建rest接口 开始
        RestTemplate restTemplate = new RestTemplate();

        // requestHeaders 设置 MediaType
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        // 将rest参数设置到HttpEntity
        HttpEntity<String> formEntity = new HttpEntity<String>(restParam.toString(), requestHeaders);

        ResponseEntity<String> result = restTemplate.exchange(startFlowRest, HttpMethod.POST, formEntity, String.class);
        // rest结果解析
        if (result.getStatusCodeValue() != 200) {// 调用发起流程成功
            System.out.println("调用删除服务出错，返回状态：" + result.getStatusCodeValue() + "，报错信息：" + result.getBody());
            return ;
        }
        String resultJson = result.getBody();
        System.out.println(resultJson);
        //成功后会返回当前实例ID 以及活动环节ID

        //调用成功后，会出现在调用者个人工作台-草稿箱
    }*/
}
