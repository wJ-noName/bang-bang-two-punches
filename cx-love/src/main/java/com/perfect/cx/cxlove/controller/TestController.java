package com.perfect.cx.cxlove.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/love/test")
    public void loveTest() {
        WeChatController weChatController = new WeChatController();
        weChatController.push();
    }
}
