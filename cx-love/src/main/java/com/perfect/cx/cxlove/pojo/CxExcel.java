package com.perfect.cx.cxlove.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class CxExcel {
    @ExcelProperty("序号")
    private String serialNum;
    @ExcelProperty("题型")
    private String questionType;
    @ExcelProperty("题目")
    private String question;
    @ExcelProperty("A")
    private String answerA;
    @ExcelProperty("B")
    private String answerB;
    @ExcelProperty("C")
    private String answerC;
    @ExcelProperty("D")
    private String answerD;
    @ExcelProperty("E")
    private String answerE;
    @ExcelProperty("F")
    private String answerF;
    @ExcelProperty("答案")
    private String answer;
    @ExcelProperty("难度")
    private String difficulty;
    @ExcelProperty("试题依据")
    private String questionBasis;
    @ExcelProperty("试题解析")
    private String questionAnalysis;
}
