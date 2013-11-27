/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.corejsf;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuranich
 */
@ManagedBean
@SessionScoped
public class UserLogout implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(UserLogout.class);
    /**
     * Creates a new instance of UserLogout
     */
    public UserLogout() {
    }
    
    public String logout() throws IOException {
        LOG.info("logout() invoked");
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        ec.invalidateSession();
//        ec.redirect("/QuizRobot/faces/index.xhtml");
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
//        FacesContext.getCurrentInstance().getExternalContext();
        return "/faces/index.xhtml";
    }
    
}
