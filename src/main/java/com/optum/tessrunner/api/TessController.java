package com.optum.tessrunner.api;

import com.optum.tessrunner.service.TessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/api")
@Api(value = "api", description = "The OCR Files API", tags = {"api"})
public class TessController {
    @Autowired
    TessService tessService;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFax(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException, IllegalAccessException, InstantiationException {
        String str = tessService.runTesseract(file);
        return new ResponseEntity(str, HttpStatus.OK);
    }
}
