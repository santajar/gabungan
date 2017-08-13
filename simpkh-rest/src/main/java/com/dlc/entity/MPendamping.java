package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_pendamping database table.
 * 
 */
@Entity
@Table(name="m_pendamping")
@NamedQuery(name="MPendamping.findAll", query="SELECT m FROM MPendamping m")
public class MPendamping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String kdpendamping;

	private String alamat;

	private String nmpendamping;

	private String status;

	//bi-directional many-to-one association to MUser
	@ManyToOne
	@JoinColumn(name="userid")
	private MUser MUser;

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

	//bi-directional many-to-one association to TKpmResertifikasi
	@OneToMany(mappedBy="MPendamping")
	private List<TKpmResertifikasi> TKpmResertifikasis;

	public MPendamping() {
	}

	public String getKdpendamping() {
		return this.kdpendamping;
	}

	public void setKdpendamping(String kdpendamping) {
		this.kdpendamping = kdpendamping;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNmpendamping() {
		return this.nmpendamping;
	}

	public void setNmpendamping(String nmpendamping) {
		this.nmpendamping = nmpendamping;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MUser getMUser() {
		return this.MUser;
	}

	public void setMUser(MUser MUser) {
		this.MUser = MUser;
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

	public List<TKpmResertifikasi> getTKpmResertifikasis() {
		return this.TKpmResertifikasis;
	}

	public void setTKpmResertifikasis(List<TKpmResertifikasi> TKpmResertifikasis) {
		this.TKpmResertifikasis = TKpmResertifikasis;
	}

	public TKpmResertifikasi addTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().add(TKpmResertifikasi);
		TKpmResertifikasi.setMPendamping(this);

		return TKpmResertifikasi;
	}

	public TKpmResertifikasi removeTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().remove(TKpmResertifikasi);
		TKpmResertifikasi.setMPendamping(null);

		return TKpmResertifikasi;
	}

}