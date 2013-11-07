/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.quiz;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Question.findByScienceSection", query = "SELECT q FROM Question q WHERE q.scienceSection = :scienceSection"),
    @NamedQuery(name = "Question.findByContentDescription", query = "SELECT q FROM Question q WHERE q.contentDescription = :contentDescription")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_ID")
    private Short questionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SCIENCE_SECTION")
    private String scienceSection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CONTENT_DESCRIPTION")
    private String contentDescription;

    public Question() {
    }

    public Question(Short questionId) {
        this.questionId = questionId;
    }

    public Question(Short questionId, String scienceSection, String contentDescription) {
        this.questionId = questionId;
        this.scienceSection = scienceSection;
        this.contentDescription = contentDescription;
    }

    public Short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Short questionId) {
        this.questionId = questionId;
    }

    public String getScienceSection() {
        return scienceSection;
    }

    public void setScienceSection(String scienceSection) {
        this.scienceSection = scienceSection;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
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
        return "jpa.quiz.Question[ questionId=" + questionId + " ]";
    }
    
}
