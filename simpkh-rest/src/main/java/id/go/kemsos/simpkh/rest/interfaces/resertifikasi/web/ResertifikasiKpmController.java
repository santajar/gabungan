/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemsos.simpkh.rest.interfaces.resertifikasi.web;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dhamarsu
 */
@Controller
public class ResertifikasiKpmController {
    
    private static final String ROOT = "/resertifikasi";
    
    private final Logger LOG = LoggerFactory.getLogger(ResertifikasiKpmController.class);
    
    @RequestMapping(value = ROOT, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postSurvey(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        if(StringUtils.isBlank(body)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = ROOT + "/{kdpendamping}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource getKpm(HttpServletRequest req, HttpServletResponse resp, 
            @PathVariable("kdpendamping") String kdpendamping) throws IOException{
        return new FileSystemResource("/home/apps/doc/SAMPLE_RESERTIFIKASI_SLEMAN.csv");
    }
    
}
