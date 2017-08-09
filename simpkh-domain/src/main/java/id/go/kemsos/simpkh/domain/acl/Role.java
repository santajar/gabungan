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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name="M_GROUP")
@NamedQueries(value={@NamedQuery(name="findRoleByName", query="select r from Role r where r.name = :name ")})
public class Role implements Serializable{
    
    private static final long serialVersionUID = 3690197650654049848L;
    
    @Id
    @TableGenerator(name = "TBL_GROUP_GEN", table = "SEQUENCE_TABLE", 
            pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_NEXT_HI_VALUE", 
            pkColumnValue = "TBL_GROUP_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TBL_GROUP_GEN")
    private Long id;
    @Column(name="NAME", length=32, unique=true)
    private String name;
    @Column(name="DESCRIPTION", length=64)
    private String description;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="GROUP_MODULE", joinColumns={@JoinColumn(name="GROUP_ID")}, inverseJoinColumns={@JoinColumn(name="MODULE_ID")})
    private Set<Module> modules = new HashSet<Module>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
    
}
