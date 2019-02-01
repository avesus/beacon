/*
 * Created on 30-Jan-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bureaueye.beacon.action.tool;

/**
 * @author ntankard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.bureaueye.beacon.bean.standard.Constants;

public class UserCounter implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        if (attributeIsUser(event)) 
            adjustUserCounter(event.getSession().getServletContext(), true);
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (attributeIsUser(event)) 
            adjustUserCounter(event.getSession().getServletContext(), false);        
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
    }

    private boolean attributeIsUser(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();       
        return Constants.USER_KEY.equals(name) && 
               value instanceof com.bureaueye.beacon.model.standard.User;
    }

    private void adjustUserCounter(ServletContext ctx, boolean userAdded) {
        Integer counterObj = (Integer) ctx.getAttribute("numUsers");
        int counter = (counterObj == null ? 0 : counterObj.intValue());
        if (userAdded) {
          counter++;
        }
        else {
            if (counter > 0) counter--;
        }       
        ctx.setAttribute("numUsers", new Integer(counter));
    }
}