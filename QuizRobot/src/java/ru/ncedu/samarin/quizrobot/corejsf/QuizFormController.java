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
import java.util.Random;
import java.util.TreeSet;
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

//    private boolean isResultPage;
    
    @EJB 
    private ScienceSectionFacade ssf;
    
    @EJB 
    private UserAnswerFacade uaf;

    @EJB 
    private UserInfoFacade uif;
    
    private List<QuestionForm> questionList = new ArrayList<>();
    private List<ScienceSection> scienceSectionList = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(QuizFormController.class);
    private String section;
    private static final int testSize = 10;

    /**
     * Creates a new instance of QuizFormController
     */
    public QuizFormController() {
//        isResultPage = false;
    }
    
    public void prepareNextQuestionList() {
        LOG.info("Current section is: " + section);
        Collection<Question> collection = ssf.findAllQuestionInSection(section);
//        isResultPage = false;
        questionList.clear();
        questionList = getRandomTest(collection);
        LOG.info(questionList.toString());
    } 
    
    public List<QuestionForm> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<QuestionForm> questionList) {
        this.questionList = questionList;
    }

//    public boolean isIsResultPage() {
//        LOG.info("Is result page: " + isResultPage);
//        return isResultPage;
//    }
//
//    public void setIsResultPage(boolean isResultPage) {
//        this.isResultPage = isResultPage;
//    }
        
    public String getSection() {
        LOG.info("section is getted: " + section);
        return section;
    }
    
    public void setSection(String section) {
        LOG.info("section is setted: " + section);
        this.section = section;
    }
    
    public String getCurrentUser() {
        ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) external.getRequest();
        return request.getRemoteUser();        
    }
    
    public void prepareScienceSectionList() {
        scienceSectionList = ssf.findAll();
        LOG.info("science section list: " + scienceSectionList);
    }
    
    public List<ScienceSection> getScienceSectionList() {
        return scienceSectionList;
    }
   
    public String resultsHandler() {
        LOG.info("handler results of answers!!=========");
        String user = getCurrentUser();
        LOG.info("Current user: " + user);
        for(QuestionForm form : questionList) {
            for(AnswerVariant var : form.getUserAnswers()) {
                uaf.create(new UserAnswer(uif.findByNickName(user), form.getQuestion(), var));
            }
        }
//        isResultPage = true;
        return "ResultPage";
    }
    
    public String getTotalResult() {
        int total = 0;
        int max_res = 0;
        for(QuestionForm form : questionList) {
            max_res += form.getNumberOfCorrectAnswers();
            total += form.getAnswerScore();
        }
        return total + " from " + max_res;
    }
    
    public boolean checkLoggedIn() {
        String login = getCurrentUser();
        return login != null && !("".equals(login));
    }

    private List<QuestionForm> getRandomTest(Collection<Question> collection) {
        ArrayList<QuestionForm> test = new ArrayList<>();
        for (Question q : collection) {
            test.add(new QuestionForm(q));
        }
        int range = test.size();
        Random rand = new Random();
        TreeSet<Integer> indexSet = new TreeSet<>();
        while(indexSet.size() < testSize) {
            indexSet.add(rand.nextInt(range));
        }
        LOG.info("sequence of question numbers: " + indexSet);
        ArrayList<QuestionForm> result = new ArrayList<>();
        for(Integer index : indexSet) {
            result.add(test.get(index));
        }
        return result;
    }
}
