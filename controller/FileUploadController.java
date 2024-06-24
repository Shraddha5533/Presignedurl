package com.presignedexample.controller;

import com.amazonaws.HttpMethod;

import com.presignedexample.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadService fileService;


    @PostMapping("/generateurl")
    public ResponseEntity<String> generateUrl(@RequestParam String extension) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                UUID.randomUUID()+"."+extension, HttpMethod.PUT));
    }

    @PutMapping ("/uploadurl")
    public ResponseEntity<String> fileuploadUrl(@RequestParam String filename) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                filename, HttpMethod.GET));
    }

}
