package ch.heigvd.amt.schedule.utility;

import ch.heigvd.amt.schedule.model.Title;

import javax.servlet.http.HttpServletRequest;

public class JobHandler {

    public static void  setPageTitle(HttpServletRequest request, String title){
        Title pageTitle = Title.builder().name(title).build();
        request.setAttribute("pageTitle", pageTitle);
    }
}
