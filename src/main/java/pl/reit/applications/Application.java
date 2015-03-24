package pl.reit.applications;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Szymon
 */
public class Application {

    private Integer id;
    
    private String name;
    
    private String content;
    
    private State state;
    
    private List<StateLog> previousStates = new ArrayList<>();
    
    private String reason;

    public Application() {
        modifyState(State.INITED);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public State getState() {
        return state;
    }

    private Application takeAction(State destinationState) {
        if (possibleActions().contains(destinationState)) {
            modifyState(destinationState);
            return this;
        }
        throw new WrongActionTakenRuntimeException();
    }

    private void modifyState(State destinationState) {
        this.state = destinationState;
        StateLog log = new StateLog(state, new Date());
        this.previousStates.add(log);
    }

    private boolean isInState(State... possibleStates) {
        for (State state : possibleStates) {
            if (state.equals(this.state)) {
                return true;
            }
        }
        return false;
    }
    
    public Application delete(String reason) {
        if (possibleActions().contains(State.DELETED)) {
            modifyState(State.DELETED);
            modifyReason(reason);
            return this;
        }
        throw new WrongActionTakenRuntimeException();
    }

    private void modifyReason(String reason) {
        if (!StringUtils.isBlank(reason)) {
            this.reason = reason;
        } else {
            throw new WrongReasonRuntimeException();
        }
    }

    public Application verify() {
        return takeAction(State.VERIFIED);
    }
    
    public Application reject(String reason) {
        if (possibleActions().contains(State.REJECTED)) {
            modifyState(State.REJECTED);
            modifyReason(reason);
            return this;
        }
        throw new WrongActionTakenRuntimeException();
    }

    private List<State> possibleActions() {
        return new ApplicationWorkflow().possibleActions(state);
    }

    public Application accept() {
        return takeAction(State.ACCEPTED);
    }

    public Application publish() {
        return takeAction(State.PUBLISHED);
    }

    public Application create() {
        return takeAction(State.CREATED);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (isEditable()) {
            this.content = content;
        } else {
            throw new WrongStateForChangeRuntimeException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isEditable()) {
            this.name = name;
        } else {
            throw new WrongStateForChangeRuntimeException();
        }
    }

    private boolean isEditable() {
        return isInState(State.INITED, State.CREATED, State.VERIFIED);
    }

    public String getReason() {
        return reason;
    }

    public List<StateLog> getPreviousStates() {
        return previousStates;
    }

    void assignId(int autoIncrement) {
        id = autoIncrement;
    }

}
