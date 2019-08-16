package com.example.demo.parameter;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class StartProcessParameter {

    /**
     * 开启流程是的传参,传input
     * @return
     */
    public List<Map> getStartInputs(String userName, String reason){
        List<Map> inputsList = new ArrayList<>();
        Map title = new HashMap();
        Map sqr = new HashMap();
        Map yy = new HashMap();

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        title.put("name", "title");
        title.put("value", userName+"的请假条，申请时间戳"+dateString);

        sqr.put("name", "shenqingren2");
        sqr.put("value", userName);

        yy.put("name", "yuanyin2");
        yy.put("value", reason);

        inputsList.add(title);
        inputsList.add(sqr);
        inputsList.add(yy);

        return inputsList;
    }

    public Map getStartCaller(String userHdId, String userName){
        Map map = new HashMap();
        map.put("userAccount", userHdId);
        map.put("userName", userName);
        return map;
    }

    public List<Map> getStartParticipantInfos(String checkHdId, String checkName, String destStepId){

        List<Map> checkList = new ArrayList<>();

        List<Map> participantList = new ArrayList<>();

        Map checkMap = new HashMap();
        checkMap.put("name", checkName);
        checkMap.put("code", checkHdId);
        checkMap.put("type", "User");
        participantList.add(checkMap);

        Map destMap = new HashMap();
        destMap.put("destStepId", destStepId);
        destMap.put("participants", participantList);

        checkList.add(destMap);

        return checkList;
    }
}
