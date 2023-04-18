package com.mycode.springboot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

@Service
public class S3ServiceImpl implements S3Service {

    private AmazonS3 s3Client;

    public S3ServiceImpl(@Autowired AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        String status = "File upload failed";
        try {
            byte[] bytes = file.getBytes();

            ObjectMetadata data = new ObjectMetadata();
            data.setContentType(file.getContentType());
            data.setContentLength(file.getSize());
    
            InputStream stream = file.getInputStream();
             
            String fileName = file.getOriginalFilename();
            
            PutObjectResult objectResult = s3Client.putObject("abhimantri-my-first-bucket", fileName, stream, data);

            status = "file has been uploaded successfully";
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    @Override
    public byte[] downloadFile(String fileName) {
        byte[] bytes = null;
        try {
            S3Object object = s3Client.getObject("abhimantri-my-first-bucket", fileName);

            S3ObjectInputStream s3is = object.getObjectContent();

            // file = new File(fileName);
    
            // OutputStream stream = new FileOutputStream(file);
    
            // stream.write(s3is.readAllBytes());

            bytes = s3is.readAllBytes();

            s3is.close();
            // stream.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return bytes;
    }
    
}
