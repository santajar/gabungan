/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.domain.references.repository;

import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dhamarsu
 */
public interface JpaKecamatanRepository extends JpaRepository<KecamatanEntity, Integer>{
    
}
