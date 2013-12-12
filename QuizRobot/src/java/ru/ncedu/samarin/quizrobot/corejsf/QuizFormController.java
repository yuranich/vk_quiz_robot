/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ncedu.samarin.quizrobot.corejsf.model.QuestionForm;
import ru.ncedu.samarin.quizrobot.jpa.entities.AnswerVariant;
import ru.ncedu.samarin.quizrobot.jpa.entities.Question;
import ru.ncedu.samarin.quizrobot.jpa.entities.ScienceSection;
import ru.ncedu.samarin.quizrobot.jpa.entities.UserAnswer;
import ru.ncedu.samarin.quizrobot.jpa.session.AnswerVariantFacade;
import ru.ncedu.samarin.quizrobot.jpa.session.QuestionFacade;
import ru.ncedu.samarin.quizrobot.jpa.session.ScienceSectionFacade;
import ru.ncedu.samarin.quizrobot.jpa.session.UserAnswerFacade;
import ru.ncedu.samarin.quizrobot.jpa.session.UserInfoFacade;

/**
 *
 * @author yuranich
 */
@Named("quizFormController")
@SessionScoped
public class QuizFormController implements Serializable{

    private boolean isResultPage;
    
    @EJB 
    private ScienceSectionFacade ssf;
    
    @EJB 
    private UserAnswerFacade uaf;

    @EJB 
    private UserInfoFacade uif;
    
    private ArrayList<QuestionForm> questionForms = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(QuizFormController.class);
    private String section = "English";
    private Enumeration<String> forTesting;

    /**
     * Creates a new instance of QuizFormController
     */
    public QuizFormController() {
        isResultPage = false;
    }
    
    public ArrayList<QuestionForm> getQuestionForms() {
        LOG.info("Question Forms: " + questionForms);
        return questionForms;
    }

    public void setQuestionForms(ArrayList<QuestionForm> questionForms) {
        this.questionForms = questionForms;
    }

    public boolean isIsResultPage() {
        LOG.info("Is result page: " + isResultPage);
        return isResultPage;
    }

    public void setIsResultPage(boolean isResultPage) {
        this.isResultPage = isResultPage;
    }
    
    public List<String> getForTesting() {
        List<String> list = new ArrayList<>();
        while(forTesting.hasMoreElements())
            list.add(forTesting.nextElement());
        return list;
    }
        
    public String getSection() {
        LOG.info("section is getted: " + section);
        return section;
    }
    
    public void setSection(String section) {
        LOG.info("section is setted!!!!!!!: " + section);
        this.section = section;
    }
    
    public String getCurrentUser() {
        ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) external.getRequest();
        return request.getRemoteUser();        
    }
    
    public List<ScienceSection> getScienceSectionList() {
        LOG.info("science section list method!!=========");
        return ssf.findAll();
    }
    
    public List<QuestionForm> getNextQuestionList() {
        Collection<Question> collection = ssf.findAllQuestionInSection(section);
        isResultPage = false;
        int count = 0;
        questionForms.clear();
        for (Iterator<Question> it = collection.iterator(); it.hasNext() && count < 10;) {
            questionForms.add(new QuestionForm(it.next()));
            ++count;
        }
        LOG.info(collection.toString());
        return questionForms;
    } 
   
    public String resultsHandler() {
        LOG.info("handler results of answers!!=========");
        String user = getCurrentUser();
        LOG.info("Current user: " + user);
        for(QuestionForm form : questionForms) {
            for(AnswerVariant var : form.getUserAnswers()) {
                uaf.create(new UserAnswer(uif.findByNickName(user), form.getQuestion(), var));
            }
        }
        isResultPage = true;
        return "ResultPage";
    }
    
    public String getTotalResult() {
        int total = 0;
        int max_res = 0;
        for(QuestionForm form : questionForms) {
            max_res += form.getNumberOfCorrectAnswers();
            total += form.getAnswerScore();
        }
        return total + " from " + max_res;
    }
    
    public boolean checkLoggedIn() {
        String login = getCurrentUser();
        return login != null && !("".equals(login));
    }
}
