package com.skhanal5.backend;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceFetcher {

    public static String getResourceFileAsString(String fileName) throws IOException {
        Resource resource = new ClassPathResource(fileName);
        File file = resource.getFile();
        return new String(Files.readAllBytes(file.toPath()));
    }
}
