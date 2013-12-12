/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.session;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.ncedu.samarin.quizrobot.jpa.entities.Question;
import ru.ncedu.samarin.quizrobot.jpa.entities.ScienceSection;

/**
 *
 * @author yuranich
 */
@Stateless
public class ScienceSectionFacade extends AbstractFacade<ScienceSection> {
    @PersistenceContext(unitName = "QuizRobotPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScienceSectionFacade() {
        super(ScienceSection.class);
    }
    
    public Collection<Question> findAllQuestionInSection(String section) {
        ScienceSection ss = (ScienceSection)em.createNamedQuery("ScienceSection.findBySection").setParameter("sectionName", section).getSingleResult();
        return ss.getQuestionCollection();
    }
}
