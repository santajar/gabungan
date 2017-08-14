/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.references;

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
@Table(name = "MST_KECAMATAN")
public class KecamatanEntity implements Serializable {
    @Id
    @Column(name = "KD_KEC", length = 6)
    private int kode;
    @Column(name = "KEC_NAME", length = 100)
    private String name;
    @JoinColumn(name = "KD_KAB", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KabupatenEntity kabupaten;

    public KecamatanEntity() {
    }

    public KecamatanEntity(int kode, String name) {
        this.kode = kode;
        this.name = name;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KabupatenEntity getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(KabupatenEntity kabupaten) {
        this.kabupaten = kabupaten;
    }
    
}
