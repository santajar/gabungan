/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.enumref;

/**
 *
 * @author dhamarsu
 */
public enum EnumStatusPendamping {
    ACTIVE("1"), NOT_ACTIVE("0");
    
    String kode;
    
    private EnumStatusPendamping(String kode){
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
    
}
