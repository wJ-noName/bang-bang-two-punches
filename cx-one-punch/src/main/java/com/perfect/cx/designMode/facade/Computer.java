package com.perfect.cx.designMode.facade;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class Computer {
    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        super();
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void startup(){
        System.out.println("this is computer up");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished");
    }

    public void shutdown(){
        System.out.println("this is computer down");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("shutdown computer finished");
    }

    static class ParamSchema {
        private String description;
        private String type;

        public void setDescription(String description) {
            this.description = description;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public String getType() {
            return type;
        }
    }
    public static void main(String[] args) {
        ParamSchema paramSchema = new ParamSchema();
        paramSchema.setDescription("1");
        paramSchema.setType("object");
        ParamSchema paramSchema2 = new ParamSchema();
        paramSchema2.setDescription("1");
        paramSchema2.setType("object");
        HashMap<String, ParamSchema> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1",paramSchema);
        objectObjectHashMap.put("2", paramSchema2);
        String s = JSONObject.toJSONString(objectObjectHashMap);
        System.out.println(s);
    }
}
