/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Szymon
 */
public class ApplicationWorkflow {
    
    public List<State> possibleActions(State current) {
        if (State.INITED.equals(current)) {
            return Arrays.asList(State.CREATED);
        }
        if (State.CREATED.equals(current)) {
            return Arrays.asList(State.VERIFIED, State.DELETED);
        }
        if (State.VERIFIED.equals(current)) {
            return Arrays.asList(State.REJECTED, State.ACCEPTED);
        }
        if (State.ACCEPTED.equals(current)) {
            return Arrays.asList(State.REJECTED, State.PUBLISHED);
        }
        return new ArrayList<>();
    }
    
    public List<State> possibleActions(Application application) {
        return possibleActions(application.getState());
    }
    
}
