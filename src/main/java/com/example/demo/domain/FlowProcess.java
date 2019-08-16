package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FlowProcess implements Serializable {
    private static final long serialVersionUID = -3601674245222628186L;

    private String actionId;

    private Map caller;

    private String flowId;

    private String formId;

    private List<Map> inputs;

    private List<Map> participantInfos;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public Map getCaller() {
        return caller;
    }

    public void setCaller(Map caller) {
        this.caller = caller;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public List<Map> getInputs() {
        return inputs;
    }

    public void setInputs(List<Map> inputs) {
        this.inputs = inputs;
    }

    public List<Map> getParticipantInfos() {
        return participantInfos;
    }

    public void setParticipantInfos(List<Map> participantInfos) {
        this.participantInfos = participantInfos;
    }
}
