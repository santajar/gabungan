package com.dlc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DownloadController {

	private static String DOWNLOAD_FOLDER = "upload";
	@RequestMapping(value = "/download/{fileName:.+}", method = RequestMethod.GET)
	public void unduh(@PathVariable("fileName") String fileName,
			HttpServletRequest request,
			HttpServletResponse response){
		String homeFolder = System.getProperty("user.home");
    	String dataDirectory = homeFolder + File.separator + DOWNLOAD_FOLDER + File.separator;
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) 
        {
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
                
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}
}
