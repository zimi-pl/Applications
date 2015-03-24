/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Szymon
 */
public class ApplicationBean {
    
    private List<Application> applications = new ArrayList<>();
    
    private int autoIncrement = 1;
    
    public ApplicationBean(List<Application> initApplications) {
        for (Application app : initApplications) {
            save(app);
        }
        applications = initApplications;
    }

    private void register(Application app) {
        app.assignId(autoIncrement);
        autoIncrement++;
    }


    public ListPage page(Criteria criteria) {
        if (criteria.getPage() <= 0) {
            throw new WrongPageRuntimeException();
        }
        final int start = (criteria.getPage() - 1) * 10;
        if (start < numberOfApplications()) {
            int stop = Math.min(criteria.getPage() * 10, numberOfApplications());
            List<Application> subList = applications.subList(start, stop);
            return new ListPage(subList, numberOfPages(), criteria.getPage());
        }
        throw new WrongPageRuntimeException();
    }
    
    private int numberOfApplications() {
        return applications.size();
    }

    private int numberOfPages() {
        return (int)Math.ceil((double)numberOfApplications()/10);
    }

    public Application save(Application application) {
        register(application);
        return application;
    }

    public Application find(int i) {
        for (Application application : applications) {
            if (application.getId().equals(i)) {
                return application;
            }
        }
        return null;
    }

}
