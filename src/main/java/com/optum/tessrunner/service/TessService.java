package com.optum.tessrunner.service;

import com.optum.tessrunner.util.FileObjectExtractor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TessService {
    public String runTesseract(MultipartFile body) throws IOException, InstantiationException, IllegalAccessException {
        TessService tessService = (TessService) new FileObjectExtractor().getGroovyObject("GTessRunner.groovy");
        String keyValue = tessService.runTesseract(body);
        return keyValue;
    }
}
