/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author yuranich
 */
@Named("quizFormController")
@SessionScoped
public class QuizFormController implements Serializable{

    /**
     * Creates a new instance of QuizFormController
     */
    public QuizFormController() {
    }
    
    public List<String> getScienceSectionList() {
        
        List<String> list = new ArrayList<String>();
        list.add("English");
        return list;
    }
    
    public Set<String> getNextQuestionSet() {
        Set<String> set = new HashSet<>();
        set.add("Question 1");
        set.add("Question 2");
        return set;
    } 
    
    public Set<String> getAnswerSetForTheQuestion() {
        Set<String> set = new HashSet<>();
        set.add("Answer 1");
        set.add("Answer 2");
        return set;        
    }
}
