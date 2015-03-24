/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Szymon
 */
class ApplicationController implements Route {

    private ApplicationBean applicationBean;
    
    public ApplicationController(ApplicationBean bean) {
        this.applicationBean = bean;
    }

    @Override
    public Object handle(Request rqst, Response rspns) throws Exception {
        final String action = rqst.queryParams("action");
        Integer id = Integer.parseInt(rqst.params("applicationId"));
        final Application application = applicationBean.find(id);
        if (!StringUtils.isEmpty(action)) {
            handleAction(application, action);
        }
        final List<State> possibleActions = new ApplicationWorkflow().possibleActions(application);
        return new ApplicationPage(application, possibleActions);
    }

    private void handleAction(Application application, String action) {
        State newState = State.valueOf(action);
        if (State.DELETED.equals(newState)) {
            application.delete("some reason");
        } else if (State.CREATED.equals(newState)) {
            application.create();
        } else if (State.VERIFIED.equals(newState)) {
            application.verify();
        } else if (State.ACCEPTED.equals(newState)) {
            application.accept();
        } else if (State.PUBLISHED.equals(newState)) {
            application.publish();
        } else if (State.REJECTED.equals(newState)) {
            application.reject("some reason");
        }
    }
    
}
