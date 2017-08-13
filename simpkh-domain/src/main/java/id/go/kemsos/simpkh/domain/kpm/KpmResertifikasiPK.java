/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.kpm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dhamarsu
 */
@Embeddable
public class KpmResertifikasiPK implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="NOPESERTA", length=15)
    private String nomorPeserta;
    
    @Column(name="NOART", length=20)
    private String nomorAnggota;

    public KpmResertifikasiPK(String nomorPeserta, String nomorAnggota) {
        this.nomorPeserta = nomorPeserta;
        this.nomorAnggota = nomorAnggota;
    }

    public String getNomorPeserta() {
        return nomorPeserta;
    }

    public void setNomorPeserta(String nomorPeserta) {
        this.nomorPeserta = nomorPeserta;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }
    
    
    
}
