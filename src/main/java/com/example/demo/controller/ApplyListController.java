package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.StartProcess.StartProcess;
import com.example.demo.StartProcess.getApplyList;
import com.example.demo.domain.Flow;
import com.example.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("apply")
public class ApplyListController {

    @Autowired
    private getApplyList getApplyList;
    @Autowired
    private StartProcess startProcess;

    @Autowired
    private UserRepository userRepository;
    /**
     * 入参：type：apply/check
     */
    @RequestMapping("/list")
    public String getApplyList(Model model,
                               @RequestParam(value="userName",defaultValue="c1") String userName,
                               @RequestParam(value="type",defaultValue="apply") String type){
        //根据用户名获取用户申请、审批列表
        //startProcess.testStartProcess();

        String hdId = userRepository.findHdIdByUserName(userName);

        if("apply".equals(type)){
            String str = getApplyList.applyList(hdId);
            Map map = JSON.parseObject(str);
            List<Flow> list = (List<Flow>)map.get("datas");
            model.addAttribute("applyList", list);
            return "aplyList/list";
        }else if("check".equals(type)){
            String str = getApplyList.checkList(hdId);
            Map map = JSON.parseObject(str);
            List<Flow> list = (List<Flow>)map.get("datas");
            model.addAttribute("applyList", list);
            return "aplyList/todoList";
        }
        return "aplyList/list";
    }



}
