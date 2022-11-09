package com.wixis.bigidy.activity.controllers;

import com.wixis.bigidy.activity.modle.Page;
import com.wixis.bigidy.activity.service.PostDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping(value = "/api/v1/post")
public class PostDetailsController {

    private final PostDetailsService service;

    @GetMapping("/get_page_img")
    public List<String> getPageScreenShots(@RequestHeader String page){
        List<String> screenShots = service.getScreenShots(page);
        return screenShots;
    }

    @GetMapping("/get_pages")
    public List<Page> getPageName(@RequestHeader String txt){
        List<Page> pages = service.getPages(txt);
        return pages;
    }
}
