package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_kpm_resertifikasi database table.
 * 
 */
@Entity
@Table(name="t_kpm_resertifikasi")
@NamedQuery(name="TKpmResertifikasi.findAll", query="SELECT t FROM TKpmResertifikasi t")
public class TKpmResertifikasi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TKpmResertifikasiPK id;

	private String alamat;

	@Column(name="hub_krt")
	private String hubKrt;

	@Column(name="jnskel_kd")
	private String jnskelKd;

	private String namaart;

	private String nik;

	private String nmpengurus;

	private String nokk;

	private Integer tahunkepesertaan;

	@Temporal(TemporalType.DATE)
	@Column(name="tgl_lhr")
	private Date tglLhr;

	//bi-directional many-to-one association to MPendamping
	@ManyToOne
	@JoinColumn(name="kdpendamping")
	private MPendamping MPendamping;

	//bi-directional many-to-one association to MstKabupaten
	@ManyToOne
	@JoinColumn(name="kdkabu")
	private MstKabupaten mstKabupaten;

	//bi-directional many-to-one association to MstKecamatan
	@ManyToOne
	@JoinColumn(name="kdkeca")
	private MstKecamatan mstKecamatan;

	//bi-directional many-to-one association to MstKelurahan
	@ManyToOne
	@JoinColumn(name="kdkelr")
	private MstKelurahan mstKelurahan;

	//bi-directional many-to-one association to MstPropinsi
	@ManyToOne
	@JoinColumn(name="kdprop")
	private MstPropinsi mstPropinsi;

	public TKpmResertifikasi() {
	}

	public TKpmResertifikasiPK getId() {
		return this.id;
	}

	public void setId(TKpmResertifikasiPK id) {
		this.id = id;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getHubKrt() {
		return this.hubKrt;
	}

	public void setHubKrt(String hubKrt) {
		this.hubKrt = hubKrt;
	}

	public String getJnskelKd() {
		return this.jnskelKd;
	}

	public void setJnskelKd(String jnskelKd) {
		this.jnskelKd = jnskelKd;
	}

	public String getNamaart() {
		return this.namaart;
	}

	public void setNamaart(String namaart) {
		this.namaart = namaart;
	}

	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNmpengurus() {
		return this.nmpengurus;
	}

	public void setNmpengurus(String nmpengurus) {
		this.nmpengurus = nmpengurus;
	}

	public String getNokk() {
		return this.nokk;
	}

	public void setNokk(String nokk) {
		this.nokk = nokk;
	}

	public Integer getTahunkepesertaan() {
		return this.tahunkepesertaan;
	}

	public void setTahunkepesertaan(Integer tahunkepesertaan) {
		this.tahunkepesertaan = tahunkepesertaan;
	}

	public Date getTglLhr() {
		return this.tglLhr;
	}

	public void setTglLhr(Date tglLhr) {
		this.tglLhr = tglLhr;
	}

	public MPendamping getMPendamping() {
		return this.MPendamping;
	}

	public void setMPendamping(MPendamping MPendamping) {
		this.MPendamping = MPendamping;
	}

	public MstKabupaten getMstKabupaten() {
		return this.mstKabupaten;
	}

	public void setMstKabupaten(MstKabupaten mstKabupaten) {
		this.mstKabupaten = mstKabupaten;
	}

	public MstKecamatan getMstKecamatan() {
		return this.mstKecamatan;
	}

	public void setMstKecamatan(MstKecamatan mstKecamatan) {
		this.mstKecamatan = mstKecamatan;
	}

	public MstKelurahan getMstKelurahan() {
		return this.mstKelurahan;
	}

	public void setMstKelurahan(MstKelurahan mstKelurahan) {
		this.mstKelurahan = mstKelurahan;
	}

	public MstPropinsi getMstPropinsi() {
		return this.mstPropinsi;
	}

	public void setMstPropinsi(MstPropinsi mstPropinsi) {
		this.mstPropinsi = mstPropinsi;
	}

}