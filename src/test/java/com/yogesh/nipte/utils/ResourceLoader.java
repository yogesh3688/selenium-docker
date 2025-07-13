package com.yogesh.nipte.utils;
/*
Simple utility to read file

 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {
    public static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);

    public static InputStream getResource(String path) throws Exception{
        log.info("reading resource from location  {}",path);
        InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if (Objects.nonNull(stream)){
            return stream;
        }
        return Files.newInputStream(Path.of(path));
    }
}
