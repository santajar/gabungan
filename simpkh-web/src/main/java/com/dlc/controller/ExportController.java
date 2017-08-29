package com.dlc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.service.KabupatenServiceInterface;
import com.dlc.service.KecamatanServiceInterface;
import com.dlc.service.PropinsiServiceInterface;
import com.dlc.service.UserService;
import com.dlc.util.HibernateUtil;

import id.go.kemsos.simpkh.domain.acl.User;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;

@Controller
public class ExportController {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	PropinsiServiceInterface propinsiServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanRepository;
	
	@Autowired
	KabupatenServiceInterface kabupatenServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanServiceInterface;
    

	@GetMapping("/export")
	public ModelAndView export(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("prop", new PropinsiEntity());
		modelAndView.addObject("allPropinsi", (ArrayList<PropinsiEntity>) propinsiServiceInterface.getAllPropinsi());
		modelAndView.addObject("kab", new KabupatenEntity());
		modelAndView.addObject("allKabupaten", (ArrayList<KabupatenEntity>) kabupatenServiceInterface.getAllKabupaten());
		modelAndView.addObject("allKecamatan", (ArrayList<KecamatanEntity>) kecamatanRepository.getAllKecamatan());
		modelAndView.addObject("kec", new KecamatanEntity());
		modelAndView.setViewName("exportresertifikasi");
		return modelAndView;
	}
	@GetMapping("/getExport")
	public ModelAndView getExportdata(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String sql = "select a.nopeserta, count(a.nopeserta) as jmlkel, a.alamat, a.tahunkepesertaan, b.nmpendamping "
				+ "from t_kpm_resertifikasi a inner join m_pendamping b on a.kdpendamping = b.kdpendamping "
				+ "group by nopeserta, a.alamat, a.tahunkepesertaan, nmpendamping";
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		return new ModelAndView("exportresertifikasi :: resultsList");
	}
	
}
