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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yuranich
 */
@Entity
@Table(name = "SCIENCE_SECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScienceSection.findAll", query = "SELECT s FROM ScienceSection s"),
    @NamedQuery(name = "ScienceSection.findById", query = "SELECT s FROM ScienceSection s where s.sectionId = :sectionId"),
    @NamedQuery(name = "ScienceSection.findBySection", query = "SELECT s FROM ScienceSection s where s.sectionName = :sectionName"),})

public class ScienceSection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name="SECTION_ID")
    private Short sectionId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SCIENCE_SECTION")
    private String sectionName;

    @OneToMany(mappedBy = "sectionId")
    private Collection<Question> questionCollection;

    public ScienceSection() {
        
    }
    
    public ScienceSection(String sectionName) {
        this.sectionName = sectionName;
    }
    
    public Short getSectionId() {
        return sectionId;
    }

    public void setSectionId(Short sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }
    
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }
    
    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScienceSection)) {
            return false;
        }
        ScienceSection other = (ScienceSection) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.ncedu.samarin.quizrobot.jpa.entities.ScienceSection[ id=" + sectionId + " ]";
    }
    
}
