package com.mycode.springboot.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycode.springboot.service.S3Service;

@RestController
@RequestMapping("/file")
public class FileUploaderController {

    private S3Service service;

    public FileUploaderController(@Autowired S3Service service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String status = service.uploadFile(file);
        return status;
    }


    @GetMapping("/{fileName}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        byte[] bytes  = service.downloadFile(fileName);

        // FileInputStream stream = null;

        // try {
        //     stream = new FileInputStream(file);
        // } catch(Exception ex) {
        //     ex.printStackTrace();
        // }


        return ResponseEntity.ok()
        .contentType(contentType(fileName))
        .header(HttpHeaders.CONTENT_DISPOSITION, String.format("inline; filename=\"" + fileName + "\""))
        .body(bytes);
    }


    private MediaType contentType(String filename) {
        String[] fileArrSplit = filename.split("\\.");
        String fileExtension = fileArrSplit[fileArrSplit.length - 1];
        switch (fileExtension) {
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "png":
                return MediaType.IMAGE_PNG;
            case "jpg":
                return MediaType.IMAGE_JPEG;
            default:
                return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
