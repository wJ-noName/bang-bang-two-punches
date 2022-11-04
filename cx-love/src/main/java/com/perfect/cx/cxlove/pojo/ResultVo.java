package com.perfect.cx.cxlove.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class ResultVo {
    private String touser;
    private String template_id;
    private String topcolor;
    private HashMap<String, DataItem> data;

    public static ResultVo initializeResultVo(String _touser, String _template_id, String _topcolor){
        return new ResultVo(_touser,_template_id,_topcolor,null);
    }

    public static ResultVo initializeResultVo(String _touser, String _template_id, String _topcolor,HashMap<String, DataItem> _data){
        return new ResultVo(_touser,_template_id,_topcolor,_data);
    }

    public ResultVo setAttribute(String key, DataItem item){
        if(this.data==null) {
            this.data = new HashMap<String,DataItem>();
        }
        this.data.put(key,item);
        return this;
    }

}
