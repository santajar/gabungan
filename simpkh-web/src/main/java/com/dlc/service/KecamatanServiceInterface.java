package com.dlc.service;

import java.util.Collection;
import java.util.List;

import id.go.kemsos.simpkh.domain.references.KecamatanEntity;

public interface KecamatanServiceInterface {

	public Collection<KecamatanEntity> getAllKecamatan();
	public List<KecamatanEntity> findById(Integer kode);
}
