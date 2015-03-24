/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.Date;

/**
 *
 * @author Szymon
 */
class StateLog {
    
    private State state;
    
    private Date date;

    public StateLog(State state, Date date) {
        this.state = state;
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public Date getDate() {
        return date;
    }
    
}
