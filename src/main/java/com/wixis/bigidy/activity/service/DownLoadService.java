package com.wixis.bigidy.activity.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DownLoadService {
    private Path foundFile;

    public enum Location{
        cover_img,post_img
    }


    public Resource getFileResource(String fileCode, Location location) throws IOException {
        foundFile=null;
        Path fileUploadDirectory = Paths.get("D:\\pushpakumara\\Wixis\\backup\\fb_scrapping_web\\fb_scrapping_screen_shot\\SeleniumPro\\screenshot\\"+location);

        Files.list(fileUploadDirectory).forEach(file->{
            if(file.getFileName().toString().startsWith(fileCode)){
                foundFile = file;
                return;
            }
        });
        if(foundFile!=null){
            return new UrlResource(foundFile.toUri());
        }
        return null;
    }
}
