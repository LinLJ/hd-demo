package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PushProcess implements Serializable {

    private static final long serialVersionUID = -1632053941754004369L;

    private String actionId;

    private int activeStepId;

    private int instId;

    private Map caller;

    private String formId;

    private List<Map> participantInfos;

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public int getActiveStepId() {
        return activeStepId;
    }

    public void setActiveStepId(int activeStepId) {
        this.activeStepId = activeStepId;
    }

    public int getInstId() {
        return instId;
    }

    public void setInstId(int instId) {
        this.instId = instId;
    }

    public Map getCaller() {
        return caller;
    }

    public void setCaller(Map caller) {
        this.caller = caller;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public List<Map> getParticipantInfos() {
        return participantInfos;
    }

    public void setParticipantInfos(List<Map> participantInfos) {
        this.participantInfos = participantInfos;
    }
}
