/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ncedu.samarin.quizrobot.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yuranich
 */
@Entity
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQuestionId", query = "SELECT q FROM Question q WHERE q.questionId = :questionId"),
    @NamedQuery(name = "Question.findByContentText", query = "SELECT q FROM Question q WHERE q.contentText = :contentText")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_ID")
    private Short questionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "CONTENT_TEXT")
    private String contentText;
    @OneToMany(mappedBy = "questionId")
    private Collection<UserAnswer> userAnswerCollection;
    @OneToMany(mappedBy = "questionId")
    private Collection<AnswerVariant> answerVariantCollection;
    
    @JoinColumn(name = "SECTION_ID", referencedColumnName = "SECTION_ID")
    @ManyToOne
    private ScienceSection sectionId;

    public Question() {
    }

    public Question(Short questionId) {
        this.questionId = questionId;
    }

    public Question(Short questionId, String contentText) {
        this.questionId = questionId;
        this.contentText = contentText;
    }

    public Short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Short questionId) {
        this.questionId = questionId;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
    
    public ScienceSection getSectionId() {
        return sectionId;
    }

    public void setSectionId(ScienceSection sectionId) {
        this.sectionId = sectionId;
    }

    @XmlTransient
    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    @XmlTransient
    public Collection<AnswerVariant> getAnswerVariantCollection() {
        return answerVariantCollection;
    }

    public void setAnswerVariantCollection(Collection<AnswerVariant> answerVariantCollection) {
        this.answerVariantCollection = answerVariantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ncedu.samarin.quizrobot.jpa.entities.Question[ questionId=" + questionId + " ]";
    }
    
}
