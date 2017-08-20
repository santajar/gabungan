package com.dlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dlc.util.MSGException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpSession;

@Controller
public class UploadController {

    private static String UPLOADED_FOLDER = "upload";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @PostMapping("/upload") //new annotation since 4.3
    public @ResponseBody String singleFileUpload(MultipartFile file,
                                   RedirectAttributes redirectAttributes, HttpSession session) {

    	String tgl = new SimpleDateFormat("yyMMddHHmmss")
				.format(new Date());
    	String filename = file.getOriginalFilename();
    	filename += "_" + tgl;
    	System.out.println(filename);
    	System.out.println("Size: " + file.getSize());
    	String lpath = "/";
    	String homeFolder = "";
    	File tujuan = null;
    	String ltomcatpath = session.getServletContext().getRealPath(lpath);
    	try {
    		homeFolder = System.getProperty("user.home");
    		File folderTujuan = new File(homeFolder +   File.separator + UPLOADED_FOLDER + File.separator);
    		if(!folderTujuan.exists()){
    			folderTujuan.mkdirs();
    		}
    		
    		tujuan = new File(folderTujuan + File.separator + filename);
			file.transferTo(tujuan);
			System.out.println("File Copy : "+tujuan.getAbsolutePath());
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	System.out.println("Path : " + tujuan);
//        return "redirect:/view";
    	return "{\"status\":1}";
    }



}