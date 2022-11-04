package com.perfect.cx.cxlove.task;

import com.perfect.cx.cxlove.controller.WeChatController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PushTask {
    @Autowired
    private WeChatController weChatController;

    @Scheduled(cron = "0 */1 * * * ?")
    public void scheduledPush(){
        weChatController.push();
    }
}
