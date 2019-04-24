package com.seymur.fileupload.service.impl;

import com.seymur.fileupload.exception.model.InvalidImageType;
import com.seymur.fileupload.service.FileService;
import com.seymur.fileupload.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger= LoggerFactory.getLogger(FileServiceImpl.class);
    @Autowired
    private Environment environment;
    @Override
    public String uploadFile(MultipartFile uploadedFile) throws IOException {

        if(FileUtils.checkIfImage(uploadedFile.getInputStream())==false){
          throw new InvalidImageType("Invalid Image type");
        }

        String uploadingDir=environment.getProperty("upload.directory");
        String base=environment.getProperty("upload.base.url");
        File directory = new File(uploadingDir);
        if (! directory.exists()){
            directory.mkdir();
        }
        String fileServerPath=uploadingDir + uploadedFile.getOriginalFilename();
        File file = new File(fileServerPath);
        uploadedFile.transferTo(file);
        return base+fileServerPath;
    }
}
