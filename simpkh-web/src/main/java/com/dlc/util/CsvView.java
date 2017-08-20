package com.dlc.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.dlc.handle.AbstractCsvView;

public class CsvView extends AbstractCsvView{

	@Override
	protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

//	    List<User> users = (List<User>) model.get("users");
	    String[] header = {"Firstname","LastName","LastName","JobTitle","Company","Address","City","Country", "PhoneNumber"};
	    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
	            CsvPreference.STANDARD_PREFERENCE);

	    csvWriter.writeHeader(header);

//	    for(User user : users){
//	        csvWriter.write(user, header);
//	    }
	    csvWriter.close();
	}

}
