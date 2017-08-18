/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.references;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "MST_KABUPATEN")
public class KabupatenEntity implements Serializable {
    @Id
    @Column(name = "KD_KAB", length = 4)
    private int kode;
    @Column(name = "KAB_NAME", length = 100)
    private String name;
    @JoinColumn(name = "KD_PROP", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private PropinsiEntity propinsi;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "kabupaten", fetch = FetchType.LAZY)
    @OrderBy("KD_KEC ASC")
//    @Fetch(FetchMode.JOIN)
    private List<KecamatanEntity> kecamatans;

    public KabupatenEntity() {
    }

    public KabupatenEntity(int kode, String name) {
        this.kode = kode;
        this.name = name;
    }

    public KabupatenEntity(int kode, String name, PropinsiEntity propinsi) {
        this.kode = kode;
        this.name = name;
        this.propinsi = propinsi;
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

    public List<KecamatanEntity> getKecamatans() {
        return kecamatans;
    }

    public void setKecamatans(List<KecamatanEntity> kecamatans) {
        this.kecamatans = kecamatans;
    }

    public PropinsiEntity getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(PropinsiEntity propinsi) {
        this.propinsi = propinsi;
    }
    
}
