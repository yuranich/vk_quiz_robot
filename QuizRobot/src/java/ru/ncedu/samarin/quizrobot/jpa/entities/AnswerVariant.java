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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ncedu.samarin.quizrobot.corejsf.model.QuestionForm;

/**
 *
 * @author yuranich
 */
@Entity
@Table(name = "ANSWER_VARIANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerVariant.findAll", query = "SELECT a FROM AnswerVariant a"),
    @NamedQuery(name = "AnswerVariant.findByAnswerId", query = "SELECT a FROM AnswerVariant a WHERE a.answerId = :answerId"),
    @NamedQuery(name = "AnswerVariant.findByVariantText", query = "SELECT a FROM AnswerVariant a WHERE a.variantText = :variantText"),
    @NamedQuery(name = "AnswerVariant.findByIsCorrect", query = "SELECT a FROM AnswerVariant a WHERE a.isCorrect = :isCorrect")})
public class AnswerVariant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANSWER_ID")
    private Short answerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "VARIANT_TEXT")
    private String variantText;
    @Column(name = "IS_CORRECT")
    private Short isCorrect;
    @OneToMany(mappedBy = "answerId")
    private Collection<UserAnswer> userAnswerCollection;
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
    @ManyToOne
    private Question questionId;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionForm.class);

    public AnswerVariant() {
    }

    public AnswerVariant(Short answerId) {
        this.answerId = answerId;
    }

    public AnswerVariant(Short answerId, String variantText) {
        this.answerId = answerId;
        this.variantText = variantText;
    }

    public Short getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Short answerId) {
        this.answerId = answerId;
    }

    public String getVariantText() {
        LOG.info(variantText);
        return variantText;
    }

    public void setVariantText(String variantText) {
        this.variantText = variantText;
    }

    public Short getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Short isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    @XmlTransient
    public Collection<UserAnswer> getUserAnswerCollection() {
        return userAnswerCollection;
    }

    public void setUserAnswerCollection(Collection<UserAnswer> userAnswerCollection) {
        this.userAnswerCollection = userAnswerCollection;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerId != null ? answerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnswerVariant)) {
            return false;
        }
        AnswerVariant other = (AnswerVariant) object;
        if ((this.answerId == null && other.answerId != null) || (this.answerId != null && !this.answerId.equals(other.answerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ncedu.samarin.quizrobot.jpa.entities.AnswerVariant[ answerId=" + answerId + " ]";
    }
    
}
