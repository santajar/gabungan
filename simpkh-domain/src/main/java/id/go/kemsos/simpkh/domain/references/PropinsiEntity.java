/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.references;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "MST_PROPINSI")
public class PropinsiEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "KD_PROP", length = 2)
    private int kode;
    @Column(name = "PROP_NAME", length = 100)
    private String name;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "propinsi", fetch = FetchType.LAZY)
    @OrderBy("KD_KAB ASC")
    private List<KabupatenEntity> kabupatens;

    public PropinsiEntity() {
    }

    public PropinsiEntity(int kode, String name) {
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

    public List<KabupatenEntity> getKabupatens() {
        return kabupatens;
    }

    public void setKabupatens(List<KabupatenEntity> kabupatens) {
        this.kabupatens = kabupatens;
    }
    
}
