/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.resertifikasi;

import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiPK;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name="T_SURVEY_RESERTIFIKASI")
public class SurveyResertifikasi implements Serializable{
    
    @EmbeddedId
    private KpmResertifikasiPK id;
    
}
