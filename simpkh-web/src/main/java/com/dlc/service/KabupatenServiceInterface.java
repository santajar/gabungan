package com.dlc.service;


import java.util.Collection;
import java.util.List;

import id.go.kemsos.simpkh.domain.references.KabupatenEntity;


public interface KabupatenServiceInterface {

	public Collection<KabupatenEntity> getAllKabupaten();
	public List<KabupatenEntity> findById(Integer kode);
}
