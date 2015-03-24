/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.reit.applications;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author Szymon
 */
public class ListController implements Route {

    private ApplicationBean applicationBean;

    public ListController(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }
    
    @Override
    public Object handle(Request request, Response rspns) throws Exception {
        final int pageId = Integer.parseInt(request.params(":pageId"));
        
        return applicationBean.page(new Criteria(pageId, null, null));
    }
}
