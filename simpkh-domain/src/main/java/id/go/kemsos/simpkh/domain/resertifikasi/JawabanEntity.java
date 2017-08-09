/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.resertifikasi;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "MST_JAWABAN")
public class JawabanEntity implements Serializable{
    
    @Id
    @Column(name = "KODE_JAWABAN", length = 10)
    private String kode;
    @Column(name = "NAME", length = 100)
    private String name;
    
    @JoinColumn(name = "KODE_SOAL", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SoalEntity soal;

    public JawabanEntity() {
    }

    public JawabanEntity(String kode, String name) {
        this.kode = kode;
        this.name = name;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SoalEntity getSoal() {
        return soal;
    }

    public void setSoal(SoalEntity soal) {
        this.soal = soal;
    }
    
}
