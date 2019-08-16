package com.example.demo.controller;

import com.example.demo.StartProcess.StartProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private StartProcess startProcess;

    @RequestMapping("/index")
    public String applyIndex(Model model, @RequestParam(value="userName",defaultValue="c1") String userName){
        model.addAttribute("userName", userName);
        return "apply";
    }
    @RequestMapping("/clickApply")
    public String clickApply(Model model,
                             @RequestParam(value="userName",defaultValue="c1") String userName,
                             @RequestParam(value="reason",defaultValue="请假default") String reason,
                             @RequestParam(value="checkName",defaultValue="b1") String checkName){


        String checkResult = startProcess.startApply(userName,checkName,reason);
        System.out.println(checkResult);

        model.addAttribute("userName", userName);
        return "aplyList/index";
    }

    @RequestMapping("/startApply")
    public String startApply(Model model, @RequestParam(value="userName",defaultValue="c1") String userName){
        model.addAttribute("userName", userName);
        return "apply";
    }
}
