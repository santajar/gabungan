package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_kecamatan database table.
 * 
 */
@Entity
@Table(name="mst_kecamatan")
@NamedQuery(name="MstKecamatan.findAll", query="SELECT m FROM MstKecamatan m")
public class MstKecamatan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kd_kec")
	private Integer kdKec;

	@Column(name="kec_name")
	private String kecName;

	//bi-directional many-to-one association to MPendamping
	@OneToMany(mappedBy="mstKecamatan")
	private List<MPendamping> MPendampings;

	//bi-directional many-to-one association to MstKabupaten
	@ManyToOne
	@JoinColumn(name="kd_kab")
	private MstKabupaten mstKabupaten;

	//bi-directional many-to-one association to MstKelurahan
	@OneToMany(mappedBy="mstKecamatan")
	private List<MstKelurahan> mstKelurahans;

	//bi-directional many-to-one association to TKpmResertifikasi
	@OneToMany(mappedBy="mstKecamatan")
	private List<TKpmResertifikasi> TKpmResertifikasis;

	public MstKecamatan() {
	}

	public Integer getKdKec() {
		return this.kdKec;
	}

	public void setKdKec(Integer kdKec) {
		this.kdKec = kdKec;
	}

	public String getKecName() {
		return this.kecName;
	}

	public void setKecName(String kecName) {
		this.kecName = kecName;
	}

	public List<MPendamping> getMPendampings() {
		return this.MPendampings;
	}

	public void setMPendampings(List<MPendamping> MPendampings) {
		this.MPendampings = MPendampings;
	}

	public MPendamping addMPendamping(MPendamping MPendamping) {
		getMPendampings().add(MPendamping);
		MPendamping.setMstKecamatan(this);

		return MPendamping;
	}

	public MPendamping removeMPendamping(MPendamping MPendamping) {
		getMPendampings().remove(MPendamping);
		MPendamping.setMstKecamatan(null);

		return MPendamping;
	}

	public MstKabupaten getMstKabupaten() {
		return this.mstKabupaten;
	}

	public void setMstKabupaten(MstKabupaten mstKabupaten) {
		this.mstKabupaten = mstKabupaten;
	}

	public List<MstKelurahan> getMstKelurahans() {
		return this.mstKelurahans;
	}

	public void setMstKelurahans(List<MstKelurahan> mstKelurahans) {
		this.mstKelurahans = mstKelurahans;
	}

	public MstKelurahan addMstKelurahan(MstKelurahan mstKelurahan) {
		getMstKelurahans().add(mstKelurahan);
		mstKelurahan.setMstKecamatan(this);

		return mstKelurahan;
	}

	public MstKelurahan removeMstKelurahan(MstKelurahan mstKelurahan) {
		getMstKelurahans().remove(mstKelurahan);
		mstKelurahan.setMstKecamatan(null);

		return mstKelurahan;
	}

	public List<TKpmResertifikasi> getTKpmResertifikasis() {
		return this.TKpmResertifikasis;
	}

	public void setTKpmResertifikasis(List<TKpmResertifikasi> TKpmResertifikasis) {
		this.TKpmResertifikasis = TKpmResertifikasis;
	}

	public TKpmResertifikasi addTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().add(TKpmResertifikasi);
		TKpmResertifikasi.setMstKecamatan(this);

		return TKpmResertifikasi;
	}

	public TKpmResertifikasi removeTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().remove(TKpmResertifikasi);
		TKpmResertifikasi.setMstKecamatan(null);

		return TKpmResertifikasi;
	}

}