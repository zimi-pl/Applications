/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.List;
import pl.reit.applications.Application;

/**
 *
 * @author Szymon
 */
public class ListPage {
    
    private int numberOfPages;
    
    private int currentPage;
    
    private List<Application> applications;

    ListPage(List<Application> subList, int numberOfPages, int currentPage) {
        this.applications = subList;
        this.numberOfPages = numberOfPages;
        this.currentPage = currentPage;
    }
    

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
}
