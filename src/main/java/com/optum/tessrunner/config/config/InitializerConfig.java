package com.optum.tessrunner.config.config;

import com.optum.tessrunner.util.FileObjectExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class InitializerConfig {
    public static boolean PROD;
    public static String[] DynamicDirs;
    public static String TesseractFolder;

    public static Environment ENV;
    public static FileObjectExtractor sfileObjectExtractor;
    public static FileObjectExtractor FileObjectExtractor;

    public static ApplicationContext applicationContext;

    @Autowired
    ApplicationContext applicationContextTmp;
    @Autowired
    private FileObjectExtractor fileObjectExtractor;
    @Autowired
    private Environment env;

    @Value("${project.dynamic.dirs}")
    private String[] dynamicDirs;
    @Value("${tesseract.data}")
    private String tesseractFolder;


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        applicationContext = applicationContextTmp;

        DynamicDirs = dynamicDirs;
        sfileObjectExtractor = fileObjectExtractor;
        ENV = env;
        FileObjectExtractor = fileObjectExtractor;
        TesseractFolder = tesseractFolder;

        FileObjectExtractor.initAllGroovy();
        Logger.getGlobal().log(Level.INFO, "hello world, I have just started up");
    }
}
