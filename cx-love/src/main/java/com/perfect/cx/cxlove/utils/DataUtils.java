package com.perfect.cx.cxlove.utils;

import com.alibaba.fastjson.JSONObject;
import com.perfect.cx.cxlove.config.WeChatConfigure;
import com.perfect.cx.cxlove.pojo.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
public class DataUtils {
    /**
     * 获取 Weather 信息
     * @param restTemplate
     * @return
     */
    public static Weather getWeather(RestTemplate restTemplate){
        String weather_api = WeChatConfigure.Weather_API;
        String responseJson = restTemplate.getForObject(WeChatConfigure.Weather_API, String.class);
        JSONObject responseResult = JSONObject.parseObject(responseJson);
        JSONObject jsonObject = responseResult.getJSONArray("newslist").getJSONObject(0);
        return jsonObject.toJavaObject(Weather.class);
    }

    /**
     * 获取 RainbowPi 信息
     * @param restTemplate
     * @return
     */
    public static String getRainbow(RestTemplate restTemplate){
        String responseJson = restTemplate.getForObject(WeChatConfigure.Rainbow_API, String.class);
        JSONObject responseResult = JSONObject.parseObject(responseJson);
        JSONObject jsonObject = responseResult.getJSONArray("newslist").getJSONObject(0);
        return jsonObject.getString("content");
    }


    /**
     * 计算生日天数 days
     * @return
     */
    public static int getBirthDays(String birthday) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 存今天
        Calendar cToday = Calendar.getInstance();
        // 存生日,公历
        Calendar cBirth = Calendar.getInstance();
        // 存生日,农历
        Calendar lBirth = Calendar.getInstance();
        int days = 0;
        try {
            // 设置生日
            cBirth.setTime(dateFormat.parse(birthday));
            //根据农历计算公历
            int[] lunarBirth = LunarCalendar.lunarToSolar(cToday.get(Calendar.YEAR), cBirth.get(Calendar.MONTH)+1, cBirth.get(Calendar.DAY_OF_MONTH), false);
            lBirth.set(lunarBirth[0], lunarBirth[1]-1, lunarBirth[2]);
            if (lBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
                // 生日已经过了，要算明年的了
                int[] lunarBirthLater = LunarCalendar.lunarToSolar(cToday.get(Calendar.YEAR)+1, cBirth.get(Calendar.MONTH)+1, cBirth.get(Calendar.DAY_OF_MONTH), false);
                lBirth.set(lunarBirthLater[0], lunarBirthLater[1]-1, lunarBirthLater[2]);
                days = (cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR)) + lBirth.get(Calendar.DAY_OF_YEAR);
            } else {
                // 生日还没过
                days = lBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 计算恋爱天数 days
     * @return
     */
    public static int getLoveDays(String loveday){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int days = 0;
        try {
            long time = System.currentTimeMillis() - dateFormat.parse(loveday).getTime();
            days = (int) (time / (24*60*60*1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    public static String getAccessToken(RestTemplate restTemplate) {
        String token = null;
        try {
            String tokenStr = restTemplate.getForObject(WeChatConfigure.Access_URL, String.class, WeChatConfigure.App_ID, WeChatConfigure.App_Secret);
            JSONObject tokenJson = JSONObject.parseObject(tokenStr);
            token = tokenJson.getString("access_token");
        } catch (Exception e) {
            log.error("获取token失败:{}", e.getMessage());
        }
        return token;
    }


}
