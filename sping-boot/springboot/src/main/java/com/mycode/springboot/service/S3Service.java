package com.mycode.springboot.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    public String uploadFile(MultipartFile file);

    public byte[] downloadFile(String fileName);
}
