package com.example.demo.domain;

import java.io.Serializable;

public class Flow implements Serializable {

    private static final long serialVersionUID = -4277718464262639962L;

    private String formId;

    private String creatorDeptName;

    private String creator;

    private Boolean cancelable;

    private String activeOperatorUsers;

    private String creatorName;

    private String title;

    private String flowName;

    private String appCat;

    private String instId;

    private String procesDate;

    private String appId;

    private String finishDate;

    private String activeStepNamed;

    private String beanId;

    private String flowId;

    private String startDate;

    private String status;

    private String flowType;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCreatorDeptName() {
        return creatorDeptName;
    }

    public void setCreatorDeptName(String creatorDeptName) {
        this.creatorDeptName = creatorDeptName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getCancelable() {
        return cancelable;
    }

    public void setCancelable(Boolean cancelable) {
        this.cancelable = cancelable;
    }

    public String getActiveOperatorUsers() {
        return activeOperatorUsers;
    }

    public void setActiveOperatorUsers(String activeOperatorUsers) {
        this.activeOperatorUsers = activeOperatorUsers;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getAppCat() {
        return appCat;
    }

    public void setAppCat(String appCat) {
        this.appCat = appCat;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getProcesDate() {
        return procesDate;
    }

    public void setProcesDate(String procesDate) {
        this.procesDate = procesDate;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getActiveStepNamed() {
        return activeStepNamed;
    }

    public void setActiveStepNamed(String activeStepNamed) {
        this.activeStepNamed = activeStepNamed;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }
}
