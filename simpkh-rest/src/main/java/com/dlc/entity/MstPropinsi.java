package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_propinsi database table.
 * 
 */
@Entity
@Table(name="mst_propinsi")
@NamedQuery(name="MstPropinsi.findAll", query="SELECT m FROM MstPropinsi m")
public class MstPropinsi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kd_prop")
	private Integer kdProp;

	@Column(name="prop_name")
	private String propName;

	//bi-directional many-to-one association to MPendamping
	@OneToMany(mappedBy="mstPropinsi")
	private List<MPendamping> MPendampings;

	//bi-directional many-to-one association to MstKabupaten
	@OneToMany(mappedBy="mstPropinsi")
	private List<MstKabupaten> mstKabupatens;

	//bi-directional many-to-one association to TKpmResertifikasi
	@OneToMany(mappedBy="mstPropinsi")
	private List<TKpmResertifikasi> TKpmResertifikasis;

	public MstPropinsi() {
	}

	public Integer getKdProp() {
		return this.kdProp;
	}

	public void setKdProp(Integer kdProp) {
		this.kdProp = kdProp;
	}

	public String getPropName() {
		return this.propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public List<MPendamping> getMPendampings() {
		return this.MPendampings;
	}

	public void setMPendampings(List<MPendamping> MPendampings) {
		this.MPendampings = MPendampings;
	}

	public MPendamping addMPendamping(MPendamping MPendamping) {
		getMPendampings().add(MPendamping);
		MPendamping.setMstPropinsi(this);

		return MPendamping;
	}

	public MPendamping removeMPendamping(MPendamping MPendamping) {
		getMPendampings().remove(MPendamping);
		MPendamping.setMstPropinsi(null);

		return MPendamping;
	}

	public List<MstKabupaten> getMstKabupatens() {
		return this.mstKabupatens;
	}

	public void setMstKabupatens(List<MstKabupaten> mstKabupatens) {
		this.mstKabupatens = mstKabupatens;
	}

	public MstKabupaten addMstKabupaten(MstKabupaten mstKabupaten) {
		getMstKabupatens().add(mstKabupaten);
		mstKabupaten.setMstPropinsi(this);

		return mstKabupaten;
	}

	public MstKabupaten removeMstKabupaten(MstKabupaten mstKabupaten) {
		getMstKabupatens().remove(mstKabupaten);
		mstKabupaten.setMstPropinsi(null);

		return mstKabupaten;
	}

	public List<TKpmResertifikasi> getTKpmResertifikasis() {
		return this.TKpmResertifikasis;
	}

	public void setTKpmResertifikasis(List<TKpmResertifikasi> TKpmResertifikasis) {
		this.TKpmResertifikasis = TKpmResertifikasis;
	}

	public TKpmResertifikasi addTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().add(TKpmResertifikasi);
		TKpmResertifikasi.setMstPropinsi(this);

		return TKpmResertifikasi;
	}

	public TKpmResertifikasi removeTKpmResertifikasi(TKpmResertifikasi TKpmResertifikasi) {
		getTKpmResertifikasis().remove(TKpmResertifikasi);
		TKpmResertifikasi.setMstPropinsi(null);

		return TKpmResertifikasi;
	}

}