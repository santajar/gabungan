/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.kpm;

import id.go.kemsos.simpkh.domain.enumref.EnumHubunganKeluarga;
import id.go.kemsos.simpkh.domain.enumref.EnumJenisKelamin;
import id.go.kemsos.simpkh.domain.enumref.EnumResertifikasiStatus;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import id.go.kemsos.simpkh.domain.references.KelurahanEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name="T_KPM_RESERTIFIKASI")
public class KpmResertifikasiEntity implements Serializable{
    
    //"NOPESERTA","TAHUNKEPESERTAAN","NMPENGURUS","NOART","NAMAART","TGL_LHR","JNSKEL_KD",
    //"JNSKEL","HUBKRT_KD","HUB_KRT","NIK","NOKK","KDPROP","NMPROP","KDKABU","NMKABU","KDKECA",
    //"NMKECA","KDKELR","NMKELR","ALAMAT"
    
    @EmbeddedId
    private KpmResertifikasiPK id;
    @Column(name = "TAHUNKEPESERTAAN")
    private Integer tahunKepesertaan;
    @Column(name = "NMPENGURUS", length = 50)
    private String namaPengurus;
    @Column(name = "NAMAART", length = 50)
    private String namaAnggota;
    @Column(name="TGL_LHR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalLahir;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "JNSKEL_KD", length = 1)
    private EnumJenisKelamin jenisKelamin;
    @Enumerated(EnumType.STRING)
    @Column(name = "HUB_KRT", length = 2)
    private EnumHubunganKeluarga hubunganKeluarga;
    
    @Column(name = "NOKK", length = 30)
    private String noKK;
    @Column(name = "NIK", length = 16)
    private String nik;
    
    @JoinColumn(name = "KDPROP", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private PropinsiEntity propinsi;
    @JoinColumn(name = "KDKABU", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KabupatenEntity kabupaten;
    @JoinColumn(name = "KDKECA", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private KecamatanEntity kecamatan;
    @JoinColumn(name = "KDKELR", insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.EAGER)
    private KelurahanEntity kelurahan;
    
    @Column(name = "ALAMAT", length = 255)
    private String alamat;
    
    @JoinColumn(name = "KDPENDAMPING", insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.EAGER)
    private PendampingEntity pendamping;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private EnumResertifikasiStatus status;
    
    @Column(name = "SURVEY", length = 4000)
    private String survey;
    
    @Column(name = "DESCRIPTION", length = 4000)
    private String desc;
    
    public KpmResertifikasiEntity() {
        this.status = EnumResertifikasiStatus.NEW;
    }

    public KpmResertifikasiPK getId() {
        return id;
    }

    public void setId(KpmResertifikasiPK id) {
        this.id = id;
    }

    public Integer getTahunKepesertaan() {
        return tahunKepesertaan;
    }

    public void setTahunKepesertaan(Integer tahunKepesertaan) {
        this.tahunKepesertaan = tahunKepesertaan;
    }

    public String getNamaPengurus() {
        return namaPengurus;
    }

    public void setNamaPengurus(String namaPengurus) {
        this.namaPengurus = namaPengurus;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public EnumJenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(EnumJenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public EnumHubunganKeluarga getHubunganKeluarga() {
        return hubunganKeluarga;
    }

    public void setHubunganKeluarga(EnumHubunganKeluarga hubunganKeluarga) {
        this.hubunganKeluarga = hubunganKeluarga;
    }

    public String getNoKK() {
        return noKK;
    }

    public void setNoKK(String noKK) {
        this.noKK = noKK;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public PendampingEntity getPendamping() {
        return pendamping;
    }

    public void setPendamping(PendampingEntity pendamping) {
        this.pendamping = pendamping;
    }

    public EnumResertifikasiStatus getStatus() {
        return status;
    }

    public void setStatus(EnumResertifikasiStatus status) {
        this.status = status;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
