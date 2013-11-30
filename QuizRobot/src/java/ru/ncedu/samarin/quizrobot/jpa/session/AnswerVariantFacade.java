/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.ncedu.samarin.quizrobot.jpa.entities.AnswerVariant;

/**
 *
 * @author yuranich
 */
@Stateless
public class AnswerVariantFacade extends AbstractFacade<AnswerVariant> {
    @EJB
    private QuestionFacade questionFacade;
    
    @PersistenceContext(unitName = "QuizRobotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnswerVariantFacade() {
        super(AnswerVariant.class);
    }
    
    public List<String> findAnswersByQuestionId(Short id) {
        Collection<AnswerVariant> answers = questionFacade.find(id).getAnswerVariantCollection();
        List<String> result = new ArrayList<String>();
        for(AnswerVariant var : answers) {
            result.add(var.getVariantText());
        }
        return result;
    }
}
