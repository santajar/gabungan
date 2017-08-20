package com.dlc.service;


import java.util.Collection;

import id.go.kemsos.simpkh.domain.references.KabupatenEntity;


public interface KabupatenServiceInterface {

	public Collection<KabupatenEntity> getAllKabupaten();
	public KabupatenEntity findById(Integer kode);
}
