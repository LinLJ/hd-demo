package com.example.demo.controller;

import com.example.demo.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("showApplication")
    public String showApplication(Model model,
                                  @RequestParam(value="instId",defaultValue="35") String instId,
                                  @RequestParam(value="userName",defaultValue="c1") String userName){
        //审批并进入下一步
        List history = checkService.getHistToryStep(instId);
        Map currentStep = checkService.getCurrentStep(instId);

        String reason = checkService.getReasonByInstId(Integer.parseInt(instId),"yuanyin");
        model.addAttribute("reason", reason);
        model.addAttribute("historyes", history);
        model.addAttribute("current", currentStep);
        model.addAttribute("instId", instId);
        model.addAttribute("userName", userName);

        if(userName.equals(currentStep.get("operator"))){
            model.addAttribute("currentCheker", true);
        }else {
            model.addAttribute("currentCheker", false);
        }
        if("部门领导".equals(currentStep.get("stepName"))){
            model.addAttribute("haveNextCheck", false);
        }else {
            model.addAttribute("haveNextCheck", true);
        }



        return "check";
    }

/*    @RequestMapping("showTodo")
    public String showTodo(Model model,
                                  @RequestParam(value="instId",defaultValue="35") String instId,
                                  @RequestParam(value="userName",defaultValue="c1") String userName){
        //审批并进入下一步
        List history = checkService.getHistToryStep(instId);
        Map currentStep = checkService.getCurrentStep(instId);
        model.addAttribute("historyes", history);
        model.addAttribute("current", currentStep);
        model.addAttribute("instId", instId);
        model.addAttribute("userName", userName);
        if(userName.equals(currentStep.get("operator"))){
            model.addAttribute("currentCheker", true);
        }else {
            model.addAttribute("currentCheker", false);
        }

        return "check";
    }*/
    @RequestMapping("clickCheck")
    public String clickApply(Model model,
                             @RequestParam(value="checkName",defaultValue="b1") String checkName,
                             @RequestParam(value="nextCheckName",defaultValue="a") String nextCheckName,
                             @RequestParam(value="instId",defaultValue="40") int instId){

        String array = checkService.clickCheck(checkName,nextCheckName,instId);
        System.out.println(array);

        return "aplyList/index";
    }

}
