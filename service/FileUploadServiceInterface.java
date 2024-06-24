package com.presignedexample.service;

import com.amazonaws.HttpMethod;

public interface FileUploadServiceInterface 
{

    String generatePreSignedUrl(String filePath, HttpMethod http);

}
