package com.clear2pay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @author
 * @Date 7/7/21 - 11:05 AM
 */
public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * get file content by file path
     * @param filePath
     * @param fileNamePre file name prefix
     * @return
     */
    public static String readFile(String filePath,String fileNamePre) {
        String fileContent = "";
        File newFile = FileUtils.createNewFile(filePath);
        File[] files = FileUtils.getFiles(newFile);
        if(files==null){
            return fileContent;
        }
        File file = Arrays.stream(files).filter(p -> !p.isDirectory()).filter(p -> p.getName().startsWith(fileNamePre)).findAny().orElse(null);
        if(file == null){
            return fileContent;
        }
        try {
            log.debug("file name : {} ", file.getName());
            byte[] data = Files.readAllBytes(file.toPath());
            fileContent = new String(data, StandardCharsets.UTF_8);
        }catch (IOException e){
            log.error("read file fail! {}", e.getMessage());
        }
        return fileContent;
    }

    /**
     * get folder files
     * @param newFile
     * @return
     */
    public static File[] getFiles(File newFile){
        if(!newFile.isDirectory()){
            return null;
        }
        File[] files = newFile.listFiles();
        return files;
    }

    /**
     * get folder, if no file will create
     * @param filePath
     * @return
     */
    public static File createNewFile(String filePath){
        File file = new File(filePath);
        if(!file.isDirectory()){
            return file;
        }
        if(!file.exists()){
            file.mkdir();
        }
        return file;
    }
}
