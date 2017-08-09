/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.references;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dhamarsu
 */
@Entity
@Table(name = "MST_RELIGION")
public class ReligionEntity implements Serializable {

    @Id
    private Long id;
    @Column(name = "RELIGION_NAME", nullable = false, length = 20)
    private String name;

    public ReligionEntity() {
    }

    public ReligionEntity(Long id, String name) {
        this.id = id;
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
    
}
