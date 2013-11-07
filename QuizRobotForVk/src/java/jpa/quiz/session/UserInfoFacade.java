/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.quiz.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.quiz.UserInfo;

/**
 *
 * @author yuranich
 */
@Stateless
public class UserInfoFacade extends AbstractFacade<UserInfo> {
    @PersistenceContext(unitName = "QuizRobotForVkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserInfoFacade() {
        super(UserInfo.class);
    }
    
}
