package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_survey_resertifikasi database table.
 * 
 */
@Embeddable
public class TSurveyResertifikasiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String noart;

	private String nopeserta;

	public TSurveyResertifikasiPK() {
	}
	public String getNoart() {
		return this.noart;
	}
	public void setNoart(String noart) {
		this.noart = noart;
	}
	public String getNopeserta() {
		return this.nopeserta;
	}
	public void setNopeserta(String nopeserta) {
		this.nopeserta = nopeserta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TSurveyResertifikasiPK)) {
			return false;
		}
		TSurveyResertifikasiPK castOther = (TSurveyResertifikasiPK)other;
		return 
			this.noart.equals(castOther.noart)
			&& this.nopeserta.equals(castOther.nopeserta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.noart.hashCode();
		hash = hash * prime + this.nopeserta.hashCode();
		
		return hash;
	}
}