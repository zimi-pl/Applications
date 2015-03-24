/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.List;

/**
 *
 * @author Szymon
 */
public class ApplicationPage {
    
    private Application application;
    
    private List<State> possibleActions;

    public ApplicationPage(Application application, List<State> possibleActions) {
        this.application = application;
        this.possibleActions = possibleActions;
    }

    public Application getApplication() {
        return application;
    }

    public List<State> getPossibleActions() {
        return possibleActions;
    }
    
    
    
}
