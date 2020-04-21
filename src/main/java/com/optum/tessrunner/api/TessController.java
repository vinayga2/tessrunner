package com.optum.tessrunner.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/api/ocrFiles")
@Api(value = "ocrFiles", description = "The OCR Files API", tags = {"ocrFiles"})
public class TessController {
    @PostMapping("/ocr/upload")
    public ResponseEntity<List<String>> uploadFax(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalAccessException, InstantiationException, IOException {
//        utilityService.ocrUpload(companyCode, ocrFolder, tesseractFolder, file);
        return new ResponseEntity("Ok", HttpStatus.OK);
    }
}
