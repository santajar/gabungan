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
public enum EnumJenisKelamin {
    LAKI_LAKI("1", "Laki-Laki"),
    PEREMPUAN("2", "Perempuan");
    
    String kode;
    String desc;

    private EnumJenisKelamin(String kode, String desc) {
        this.kode = kode;
        this.desc = desc;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
