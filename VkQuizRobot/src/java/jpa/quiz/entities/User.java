/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.quiz.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yuranich
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByQuestionId", query = "SELECT u FROM User u WHERE u.questionId = :questionId"),
    @NamedQuery(name = "User.findByAnswer", query = "SELECT u FROM User u WHERE u.answer = :answer"),
    @NamedQuery(name = "User.findByCorAnswer", query = "SELECT u FROM User u WHERE u.corAnswer = :corAnswer"),
    @NamedQuery(name = "User.findByMatches", query = "SELECT u FROM User u WHERE u.matches = :matches"),
    @NamedQuery(name = "User.findByAnswerNumber", query = "SELECT u FROM User u WHERE u.answerNumber = :answerNumber"),
    @NamedQuery(name = "User.findByRightAnswerNumber", query = "SELECT u FROM User u WHERE u.rightAnswerNumber = :rightAnswerNumber")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "question_id")
    private int questionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "answer")
    private char answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cor_answer")
    private char corAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matches")
    private char matches;
    @Basic(optional = false)
    @NotNull
    @Column(name = "answer_number")
    private int answerNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "right_answer_number")
    private int rightAnswerNumber;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, int questionId, char answer, char corAnswer, char matches, int answerNumber, int rightAnswerNumber) {
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
        this.corAnswer = corAnswer;
        this.matches = matches;
        this.answerNumber = answerNumber;
        this.rightAnswerNumber = rightAnswerNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    public char getCorAnswer() {
        return corAnswer;
    }

    public void setCorAnswer(char corAnswer) {
        this.corAnswer = corAnswer;
    }

    public char getMatches() {
        return matches;
    }

    public void setMatches(char matches) {
        this.matches = matches;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public int getRightAnswerNumber() {
        return rightAnswerNumber;
    }

    public void setRightAnswerNumber(int rightAnswerNumber) {
        this.rightAnswerNumber = rightAnswerNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.quiz.entities.User[ userId=" + userId + " ]";
    }
    
}
