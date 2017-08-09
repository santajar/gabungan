/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.acl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "M_USER")
public class User  implements Serializable {
    
    private static final long serialVersionUID = 3832626162173359411L;
    
    @Id
    @TableGenerator(name = "TBL_USER_GEN", table = "SEQUENCE_TABLE", 
            pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_NEXT_HI_VALUE", 
            pkColumnValue = "TBL_USER_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TBL_USER_GEN")
    private Long id;
    @Column(name="USERID", nullable=false, length=50, unique=true)
    private String username;
    @Column(name="PASSWORD", nullable=false)
    private String password;
    @Column(name="NAMAUSER", nullable=false, length=50)
    private String fullName;
    @Column(name="KDPROP", length=2)
    private String kodePropinsi;
    @Column(name="KDKABU", length=4)
    private String kodeKabupaten;
    @Column(name="KDKECA", length=6)
    private String kodeKecamatan;
    @Column(name="KDKELR", length=8)
    private String kodeKelurahan;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="USER_GROUP", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns={@JoinColumn(name="GROUP_ID")})
    private Set<Role> roles = new HashSet<>();
    @Column(name="ACCOUNT_ENABLED")
    private boolean enabled;
    @Column(name="ACCOUNT_EXPIRED", nullable=false)
    private boolean accountExpired;
    @Column(name="ACCOUNT_LOCKED", nullable=false)
    private boolean accountLocked;
    @Column(name="CREDENTIALS_EXPIRED", nullable=false)
    private boolean credentialsExpired;

    public User() {
    }

    public User(Long id, String username, String password, String fullName, String kodePropinsi, String kodeKabupaten, String kodeKecamatan, String kodeKelurahan, boolean enabled, boolean accountExpired, boolean accountLocked, boolean credentialsExpired) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.kodePropinsi = kodePropinsi;
        this.kodeKabupaten = kodeKabupaten;
        this.kodeKecamatan = kodeKecamatan;
        this.kodeKelurahan = kodeKelurahan;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialsExpired = credentialsExpired;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKodePropinsi() {
        return kodePropinsi;
    }

    public void setKodePropinsi(String kodePropinsi) {
        this.kodePropinsi = kodePropinsi;
    }

    public String getKodeKabupaten() {
        return kodeKabupaten;
    }

    public void setKodeKabupaten(String kodeKabupaten) {
        this.kodeKabupaten = kodeKabupaten;
    }

    public String getKodeKecamatan() {
        return kodeKecamatan;
    }

    public void setKodeKecamatan(String kodeKecamatan) {
        this.kodeKecamatan = kodeKecamatan;
    }

    public String getKodeKelurahan() {
        return kodeKelurahan;
    }

    public void setKodeKelurahan(String kodeKelurahan) {
        this.kodeKelurahan = kodeKelurahan;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }
    
    
    
    
}
