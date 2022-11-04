package com.perfect.cx.cxlove.controller;

import com.perfect.cx.cxlove.config.WeChatConfigure;
import com.perfect.cx.cxlove.pojo.DataItem;
import com.perfect.cx.cxlove.pojo.ResultVo;
import com.perfect.cx.cxlove.pojo.Weather;
import com.perfect.cx.cxlove.utils.DataUtils;
import com.perfect.cx.cxlove.utils.RestTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class WeChatController {


    /**
     * {{date.DATA}}
     * {{remark.DATA}}
     * 所在城市：{{city.DATA}}
     * 今日天气：{{weather.DATA}}
     * 气温变化：{{min_temperature.DATA}} ~ {{max_temperature.DATA}}
     * 今日建议：{{tips.DATA}}
     * 今天是我们恋爱的第 {{love_days.DATA}} 天
     * 距离xx生日还有 {{girl_birthday.DATA}} 天
     * 距离xx生日还有 {{boy_birthday.DATA}} 天
     * {{rainbow.DATA}}
     */
    public void push(){
        RestTemplate restTemplate = RestTemplateUtils.getInstance();
        ResultVo resultVo = ResultVo.initializeResultVo(WeChatConfigure.Open_ID,WeChatConfigure.Template_ID,WeChatConfigure.Top_Color);
        //1.设置城市与天气信息
        Weather weather = DataUtils.getWeather(restTemplate);
        resultVo.setAttribute("date",new DataItem(weather.getDate() + " " + weather.getWeek(),"#00BFFF"));
        resultVo.setAttribute("city",new DataItem(weather.getArea(),null));
        resultVo.setAttribute("weather",new DataItem(weather.getWeather(),"#1f95c5"));
        resultVo.setAttribute("min_temperature",new DataItem(weather.getLowest(),"#0ace3c"));
        resultVo.setAttribute("max_temperature",new DataItem(weather.getHighest(),"#dc1010"));
        resultVo.setAttribute("tips",new DataItem(weather.getTips(),null));
        //2.设置日期相关
        int love_days = DataUtils.getLoveDays(WeChatConfigure.Love_Day);
        int girl_birthday = DataUtils.getBirthDays(WeChatConfigure.Girl_Birthday);
        int boy_birthday = DataUtils.getBirthDays(WeChatConfigure.Boy_Birthday);
        resultVo.setAttribute("love_days",new DataItem(love_days+"","#FFA500"));
        resultVo.setAttribute("girl_birthday",new DataItem(girl_birthday+"","#FFA500"));
        resultVo.setAttribute("boy_birthday",new DataItem(boy_birthday+"","#FFA500"));
        //3.设置彩虹屁
        String rainbow =  DataUtils.getRainbow(restTemplate);
        resultVo.setAttribute("rainbow",new DataItem(rainbow,"#FF69B4"));
        //4.其他
        String remark = "❤";
        if(DataUtils.getBirthDays(WeChatConfigure.Love_Day) == 0){
            remark = "今天是恋爱周年纪念日！永远爱你~";
        }else if(girl_birthday == 0){
            remark = "今天是美欣欣宝贝的生日！生日快乐哟~";
        }else if(boy_birthday == 0){
            remark = "今天是王大帅的生日！别忘了好好爱他~";
        }
        resultVo.setAttribute("remark",new DataItem(remark,"#FF1493"));
        //5.发送请求，推送消息
        String responseStr = restTemplate.postForObject(WeChatConfigure.Send_URL, resultVo, String.class, DataUtils.getAccessToken(restTemplate));
        log.info("推送消息返回:{}", responseStr);
    }
}
