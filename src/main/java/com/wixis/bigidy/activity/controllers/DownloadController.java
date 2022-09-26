package com.wixis.bigidy.activity.controllers;

import com.wixis.bigidy.activity.service.DownLoadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping(value = "/api/v1")
public class DownloadController {

    private final DownLoadService downLoadService;


    @GetMapping("/downloadFile/cover_img/{fileName}")
    public ResponseEntity<?> downloadFile_CoverImg(@PathVariable String fileName, HttpServletRequest request){
        return downloadFile(fileName, DownLoadService.Location.cover_img, request);
    }

    @GetMapping("/downloadFile/post_img/{fileName}")
    public ResponseEntity<?> downloadFile_PostImg(@PathVariable String fileName, HttpServletRequest request){
        return downloadFile(fileName, DownLoadService.Location.post_img, request);
    }

    private ResponseEntity<?> downloadFile(String fileName, DownLoadService.Location location, HttpServletRequest request){
        Resource resource;
        String contentType;
        try {
            resource = downLoadService.getFileResource(fileName, location);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            /*if (resource==null){
                System.out.println("ok");
                return new ResponseEntity<>("File Not found..", HttpStatus.NOT_FOUND);
            }*/
            log.info("D o w n l o a d  S o m e  F i l e  N a m e  I s "+fileName);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }catch (NullPointerException e){
            log.error(fileName+"  W h i c h  F i l e  I s  N o t  F o u n d . . . ");
            return new ResponseEntity<>("File Not found..", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/media")
    public String image(@RequestBody byte[] file) throws IOException {
        System.out.println(file);

        File filePath = new File("filesave/"+"tr.mp4");
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(file);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
