/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.ncedu.samarin.quizrobot.jpa.entities.Question;

/**
 *
 * @author yuranich
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {
    @PersistenceContext(unitName = "QuizRobotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }
    
    public List<Question> findAllInSection(String section) {
        Query query = em.createNamedQuery("Question.findByScienceSection").setParameter("scienceSection", section);
        return query.getResultList();
        
    }
    
}
