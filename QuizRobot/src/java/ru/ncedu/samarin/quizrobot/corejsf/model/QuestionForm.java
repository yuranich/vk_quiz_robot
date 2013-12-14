/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.corejsf.model;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ncedu.samarin.quizrobot.jpa.entities.AnswerVariant;
import ru.ncedu.samarin.quizrobot.jpa.entities.Question;

/**
 *
 * @author yuranich
 */
public class QuestionForm {
    private Question question;
    private AnswerVariant[] userAnswers;
    private AnswerVariant[] allAnswers;
    private AnswerVariant[] correctAnswers;
    
    private static final Logger LOG = LoggerFactory.getLogger(QuestionForm.class);
    
    public QuestionForm() {
    }

    public QuestionForm(Question question) {
        this.question = question;
        allAnswers = question.getAnswerVariantCollection().toArray(new AnswerVariant[]{});
        List<AnswerVariant> list = new ArrayList<>();
        for(AnswerVariant ans : allAnswers) {
            if ((int)(ans.getIsCorrect()) == 1) {
                list.add(ans);
            }
        }
        correctAnswers = list.toArray(new AnswerVariant[]{});
    }

    public QuestionForm(Question question, AnswerVariant[] asnwers) {
        this(question);
        this.userAnswers = asnwers;
    }

    public Question getQuestion() {
        return question;
    }

    public AnswerVariant[] getUserAnswers() {
        LOG.info("user answers: " + userAnswers);
        return userAnswers;
    }

    public void setQuestion(Question question) {
        this.question = question;
        allAnswers = question.getAnswerVariantCollection().toArray(new AnswerVariant[]{});
        List<AnswerVariant> list = new ArrayList<>();
        for(AnswerVariant ans : allAnswers) {
            if ((int)(ans.getIsCorrect()) == 1) {
                list.add(ans);
            }
        }
        correctAnswers = list.toArray(new AnswerVariant[]{});
    }

    public void setUserAnswers(AnswerVariant[] userAnswers) {
        LOG.info("user variants: " + userAnswers);
        this.userAnswers = userAnswers;
    }

    public AnswerVariant[] getAllAnswers() {
        LOG.info("all answers: " + allAnswers);
        return allAnswers;
    }

    public void setAllAnswers(AnswerVariant[] allAnswers) {
        this.allAnswers = allAnswers;
    }

    public int getNumberOfCorrectAnswers() {
        return correctAnswers.length;
    }
    
    public int getAnswerScore() {
        int count = 0;
        for(AnswerVariant var : userAnswers) {
            if ((int)(var.getIsCorrect()) == 1)
                count++;
            else 
                count--;
        }
        return (count >= 0)? count: 0;
    }
}
