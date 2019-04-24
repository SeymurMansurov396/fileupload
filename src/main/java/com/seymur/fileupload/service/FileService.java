package com.seymur.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileService {

   String uploadFile(MultipartFile file) throws IOException;
}
