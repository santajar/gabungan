package com.dlc.service;


import java.util.Collection;
import java.util.List;



public interface TKPMServiceInterface {

	public List<Object[]> findAll(Integer prov,Integer kab, Integer kec, String pdp, String stat);
	public List<Object[]> findAll(Integer prov,Integer kab, Integer kec, String pdp);
}
