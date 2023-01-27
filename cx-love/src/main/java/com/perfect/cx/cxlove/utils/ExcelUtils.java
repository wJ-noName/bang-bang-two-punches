package com.perfect.cx.cxlove.utils;

import com.alibaba.excel.EasyExcel;
import com.perfect.cx.cxlove.pojo.CxExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ExcelUtils {
    public static void main(String[] args) {
        excelAnalysis();
    }
    public static void excelAnalysis(){
        String fileName = "cx.xls";
        List<CxExcel> cxExcels = EasyExcel.read(fileName).head(CxExcel.class).sheet().doReadSync();
        StringBuilder builder = new StringBuilder();
        cxExcels.forEach(o -> {
            if (!"判断".equals(o.getQuestionType())){
                builder.append(o.getSerialNum() + ".");
                builder.append("(" + o.getQuestionType() + ")");
                builder.append(o.getQuestion());
                builder.append(o.getAnswer() + "\n");
                builder.append("A:" + o.getAnswerA() + "\n");
                builder.append("B:" + o.getAnswerB() + "\n");
                builder.append("C:" + o.getAnswerC() + "\n");
                builder.append("D:" + o.getAnswerD() + "\n");
                if (StringUtils.isNotBlank(o.getAnswerE())) {
                    builder.append("E:" + o.getAnswerE() + "\n");
                }
                if (StringUtils.isNotBlank(o.getAnswerF())) {
                    builder.append("f:" + o.getAnswerF() + "\n");
                }
            } else {
                builder.append("\n\n" + o.getSerialNum() + ".");
                builder.append("(" + o.getQuestionType() + ")");
                builder.append(o.getQuestion() + "");
                builder.append("A".equals(o.getAnswer()) ? "正确" : "错误");
            }
        });
        System.out.println(builder);
    }
}
