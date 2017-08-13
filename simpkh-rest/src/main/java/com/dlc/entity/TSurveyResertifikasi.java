package com.dlc.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_survey_resertifikasi database table.
 * 
 */
@Entity
@Table(name="t_survey_resertifikasi")
@NamedQuery(name="TSurveyResertifikasi.findAll", query="SELECT t FROM TSurveyResertifikasi t")
public class TSurveyResertifikasi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TSurveyResertifikasiPK id;

	public TSurveyResertifikasi() {
	}

	public TSurveyResertifikasiPK getId() {
		return this.id;
	}

	public void setId(TSurveyResertifikasiPK id) {
		this.id = id;
	}

}