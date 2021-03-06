/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.ncedu.samarin.quizrobot.jpa.entities.UserInfo;

/**
 *
 * @author yuranich
 */
@Stateless
public class UserInfoFacade extends AbstractFacade<UserInfo> {
    @PersistenceContext(unitName = "QuizRobotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserInfoFacade() {
        super(UserInfo.class);
    }
    
    public UserInfo findByNickName(String nickName) {
        Query query = em.createNamedQuery("UserInfo.findByNickName").setParameter("nickName", nickName);
        return (UserInfo)query.getSingleResult();
    }
    
}
