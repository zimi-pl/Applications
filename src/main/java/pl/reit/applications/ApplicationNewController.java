/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.List;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Szymon
 */
public class ApplicationNewController implements Route {

    private ApplicationBean applicationBean;
    
    public ApplicationNewController(ApplicationBean bean) {
        this.applicationBean = bean;
    }
    
    public Object handle(Request rqst, Response rspns) throws Exception {
        final Application application = new Application();
        if ("POST".equals(rqst.requestMethod())) {
            application.setName(rqst.queryParams("name"));
            application.setContent(rqst.queryParams("content"));
            application.create();
            applicationBean.create(application);
        }
        final List<State> possibleActions = new ApplicationWorkflow().possibleActions(application);
        return new ApplicationPage(application, possibleActions);
    }

}
