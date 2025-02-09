package com.presignedexample.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class FileUploadService implements FileUploadServiceInterface 
{
    @Autowired
    private AmazonS3 amazonS3;

    @Value("${application.bucket.name}")
    private String bucketName;

    public String generatePreSignedUrl(String filePath, HttpMethod http) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE,2);
        return amazonS3.generatePresignedUrl(bucketName,filePath,cal.getTime(),http).toString();
    }

}
