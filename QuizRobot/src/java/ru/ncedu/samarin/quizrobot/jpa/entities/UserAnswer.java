/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yuranich
 */
@Entity
@Table(name = "USER_ANSWER")
@XmlRootElement
@SequenceGenerator(name = "USER_ANSWER_SEQ", initialValue = 10)
@NamedQueries({
    @NamedQuery(name = "UserAnswer.findAll", query = "SELECT u FROM UserAnswer u"),
    @NamedQuery(name = "UserAnswer.findByUserAnswerId", query = "SELECT u FROM UserAnswer u WHERE u.userAnswerId = :userAnswerId")})
public class UserAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ANSWER_SEQ")
    @Column(name = "USER_ANSWER_ID")
    private Integer userAnswerId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserInfo userId;
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
    @ManyToOne
    private Question questionId;
    @JoinColumn(name = "ANSWER__ID", referencedColumnName = "ANSWER_ID")
    @ManyToOne
    private AnswerVariant answerId;

    public UserAnswer() {
    }

    public UserAnswer(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public UserAnswer(UserInfo userId, Question questionId, AnswerVariant answerId) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
    }    

    public Integer getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(Integer userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public AnswerVariant getAnswerId() {
        return answerId;
    }

    public void setAnswerId(AnswerVariant answerId) {
        this.answerId = answerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAnswerId != null ? userAnswerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAnswer)) {
            return false;
        }
        UserAnswer other = (UserAnswer) object;
        if ((this.userAnswerId == null && other.userAnswerId != null) || (this.userAnswerId != null && !this.userAnswerId.equals(other.userAnswerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ncedu.samarin.quizrobot.jpa.entities.UserAnswer[ userAnswerId=" + userAnswerId + " ]";
    }
    
}
