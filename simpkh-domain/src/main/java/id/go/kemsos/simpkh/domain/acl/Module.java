/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.acl;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "M_MODULE")
public class Module implements Serializable{

    private static final long serialVersionUID = 4943553634623576027L;
    @Id
    @TableGenerator(name = "TBL_MODULE_GEN", table = "SEQUENCE_TABLE", 
            pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_NEXT_HI_VALUE", 
            pkColumnValue = "TBL_MODULE_ID", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TBL_MODULE_GEN")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 50, unique = true, nullable = false)
    private String name;
    @Column(name = "URL", length = 100, nullable = false)
    private String url;

    
    public Module() {
		super();
	}

	public Module(Long id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
