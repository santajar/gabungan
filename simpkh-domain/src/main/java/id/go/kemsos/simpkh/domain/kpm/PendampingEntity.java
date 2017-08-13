/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.kpm;

import id.go.kemsos.simpkh.domain.acl.User;
import id.go.kemsos.simpkh.domain.enumref.EnumStatusPendamping;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import id.go.kemsos.simpkh.domain.references.KelurahanEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name="M_PENDAMPING", uniqueConstraints={@UniqueConstraint(columnNames={"USERID"})})
public class PendampingEntity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="KDPENDAMPING", nullable=false, length=9)
    private String kdpendamping;
    @Column(name="NMPENDAMPING", nullable=false, length=50)
    private String nmpendamping;
    @Column(name="ALAMAT", length=150)
    private String alamat;
    
    @JoinColumn(name = "KDPROP", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private PropinsiEntity propinsi;
    @JoinColumn(name = "KDKABU", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KabupatenEntity kabupaten;
    @JoinColumn(name = "KDKECA", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KecamatanEntity kecamatan;
    @JoinColumn(name = "KDKELR", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KelurahanEntity kelurahan;
    
    @JoinColumn(name = "USERID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS", length=1)
    private EnumStatusPendamping status;

    public String getKdpendamping() {
        return kdpendamping;
    }

    public void setKdpendamping(String kdpendamping) {
        this.kdpendamping = kdpendamping;
    }

    public String getNmpendamping() {
        return nmpendamping;
    }

    public void setNmpendamping(String nmpendamping) {
        this.nmpendamping = nmpendamping;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public PropinsiEntity getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(PropinsiEntity propinsi) {
        this.propinsi = propinsi;
    }

    public KabupatenEntity getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(KabupatenEntity kabupaten) {
        this.kabupaten = kabupaten;
    }

    public KecamatanEntity getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(KecamatanEntity kecamatan) {
        this.kecamatan = kecamatan;
    }

    public KelurahanEntity getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(KelurahanEntity kelurahan) {
        this.kelurahan = kelurahan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EnumStatusPendamping getStatus() {
        return status;
    }

    public void setStatus(EnumStatusPendamping status) {
        this.status = status;
    }
    
}
