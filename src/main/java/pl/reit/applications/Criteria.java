/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

/**
 *
 * @author Szymon
 */
public class Criteria {
    
    private int page;
    
    private String inName;
    
    private State state;

    public Criteria(int page, String inName, State state) {
        this.page = page;
        this.inName = inName;
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public String getInName() {
        return inName;
    }

    public State getState() {
        return state;
    }
    
    
}
