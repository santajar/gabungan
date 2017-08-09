/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.resertifikasi;

import id.go.kemsos.simpkh.domain.enumref.EnumSoalType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "MST_SOAL")
public class SoalEntity implements Serializable{
    @Id
    @Column(name = "KODE_SOAL", length = 10)
    private String kode;
    @Column(name = "ORDERED")
    private int order;
    @Column(name = "QUESTION", length = 100)
    private String question;
    @Column(name = "MAX_DIGIT")
    private int maxDigit;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private EnumSoalType type;
    
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "soal", fetch = FetchType.LAZY)
    private List<JawabanEntity> jawabans;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private SoalEntity parent;
    
    @OneToMany(mappedBy="parent")
    private List<SoalEntity> child;

    public SoalEntity() {
    }

    public SoalEntity(String kode, int order, String question, int maxDigit, EnumSoalType type) {
        this.kode = kode;
        this.order = order;
        this.question = question;
        this.maxDigit = maxDigit;
        this.type = type;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getMaxDigit() {
        return maxDigit;
    }

    public void setMaxDigit(int maxDigit) {
        this.maxDigit = maxDigit;
    }

    public EnumSoalType getType() {
        return type;
    }

    public void setType(EnumSoalType type) {
        this.type = type;
    }

    public List<JawabanEntity> getJawabans() {
        return jawabans;
    }

    public void setJawabans(List<JawabanEntity> jawabans) {
        this.jawabans = jawabans;
    }

    public SoalEntity getParent() {
        return parent;
    }

    public void setParent(SoalEntity parent) {
        this.parent = parent;
    }

    public List<SoalEntity> getChild() {
        return child;
    }

    public void setChild(List<SoalEntity> child) {
        this.child = child;
    }
    
    
}
