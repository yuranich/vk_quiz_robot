/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.quiz.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.quiz.Question;

/**
 *
 * @author yuranich
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {
    @PersistenceContext(unitName = "QuizRobotForVkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }
    
}
