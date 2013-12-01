/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ncedu.samarin.quizrobot.jpa.entities.Question;
import ru.ncedu.samarin.quizrobot.jpa.session.AnswerVariantFacade;
import ru.ncedu.samarin.quizrobot.jpa.session.QuestionFacade;

/**
 *
 * @author yuranich
 */
@Named("quizFormController")
@SessionScoped
public class QuizFormController implements Serializable{

    @EJB private QuestionFacade qf;
    
    private String section = "English";
    
    private static final Logger LOG = LoggerFactory.getLogger(QuizFormController.class);
    
    public String getSection() {
        return section;
    }
    
    public void setSection(String section) {
        LOG.info("section is setted");
        this.section = section;
    }
    
    /**
     * Creates a new instance of QuizFormController
     */
    public QuizFormController() {
    }
    
    public List<String> getScienceSectionList() {
        
        List<String> list = new ArrayList<>();
        list.add("English");
        return list;
    }
    
    public List<Question> getNextQuestionList() {
        return qf.findAllInSection(section).subList(0, 10);
    } 
   
    public String resultsHandler() {
        return null;
    }
}
