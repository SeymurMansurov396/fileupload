package com.seymur.fileupload.controller;


import com.seymur.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class UploadController {

    @Autowired
    private FileService fileService;


    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadingPost(@RequestParam("file") MultipartFile uploadingFile)  {
        Map<String,Object> response=new HashMap<>();

        try {
           String filePathInServer=fileService.uploadFile(uploadingFile);
           response.put("success",true);
           response.put("filePath",filePathInServer);
           return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

            response.put("success",false);
            response.put("filePath",null);
            response.put("errorStack",e.getLocalizedMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}
