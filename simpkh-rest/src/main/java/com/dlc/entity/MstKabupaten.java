package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_kabupaten database table.
 * 
 */
@Entity
@Table(name="mst_kabupaten")
@NamedQuery(name="MstKabupaten.findAll", query="SELECT m FROM MstKabupaten m")
public class MstKabupaten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kd_kab")
	private Integer kdKab;

	@Column(name="kab_name")
	private String kabName;

	//bi-directional many-to-one association to MPendamping
	@OneToMany(mappedBy="mstKabupaten")
	private List<MPendamping> MPendampings;

	//bi-directional many-to-one association to MstPropinsi
	@ManyToOne
	@JoinColumn(name="kd_prop")
	private MstPropinsi mstPropinsi;

	//bi-directional many-to-one association to MstKecamatan
	@OneToMany(mappedBy="mstKabupaten")
	private List<MstKecamatan> mstKecamatans;

	//bi-directional many-to-one association to TKpmResertifikasi
	@OneToMany(mappedBy="mstKabupaten")
	private List<TKpmResertifikasi> TKpmResertifikasis;

	public MstKabupaten() {
	}

	public Integer getKdKab() {
		return this.kdKab;
	}

	public void setKdKab(Integer kdKab) {
		this.kdKab = kdKab;
	}

	public String getKabName() {
		return this.kabName;
	}

	public void setKabName(String kabName) {
		this.kabName = kabName;
	}

	public List<MPendamping> getMPendampings() {
		return this.MPendampings;
	}

	public void setMPendampings(List<MPendamping> MPendampings) {
		this.MPendampings = MPendampings;
	}

	public MPendamping addMPendamping(MPendamping MPendamping) {
		getMPendampings().add(MPendamping);
		MPendamping.setMstKabupaten(this);

		return MPendamping;
	}

	public MPendamping removeMPendamping(MPendamping MPendamping) {
		getMPendampings().remove(MPendamping);
		MPendamping.setMstKabupaten(null);

		return MPendamping;
	}

	public MstPropinsi getMstPropinsi() {
		return this.mstPropinsi;
	}

	public void setMstPropinsi(MstPropinsi mstPropinsi) {
		this.mstPropinsi = mstPropinsi;
	}

	public List<MstKecamatan> getMstKecamatans() {
		return this.mstKecamatans;
	}

	public void setMstKecamatans(List<MstKecamatan> mstKecamatans) {
		this.mstKecamatans = mstKecamatans;
	}

	public MstKecamatan addMstKecamatan(MstKecamatan mstKecamatan) {
		getMstKecamatans().add(mstKecamatan);
		mstKecamatan.setMstKabupaten(this);

		return mstKecamatan;
	}

	public MstKecamatan removeMstKecamatan(MstKecamatan mstKecamatan) {
		getMstKecamatans().remove(mstKecamatan);
		mstKecamatan.setMstKabupaten(null);

		return mstKecamatan;
	}

	public List<TKpmResertifikasi> getTKpmResertifikasis() {
		return this.TKpmResertifikasis;
	}

	public void setTKpmResertifikasis(List<TKpmResertifikasi> TKpmResertifikasis) {
		this.TKpmResertifikasis = TKpmResertifikasis;
	}

	public TKpmResertifikasi addTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().add(TKpmResertifikasi);
		TKpmResertifikasi.setMstKabupaten(this);

		return TKpmResertifikasi;
	}

	public TKpmResertifikasi removeTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().remove(TKpmResertifikasi);
		TKpmResertifikasi.setMstKabupaten(null);

		return TKpmResertifikasi;
	}

}