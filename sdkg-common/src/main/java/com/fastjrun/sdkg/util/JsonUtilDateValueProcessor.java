package com.fastjrun.sdkg.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonUtilDateValueProcessor implements JsonValueProcessor {

    private String format = "yyyy-MM-dd HH:mm:ss";

    public JsonUtilDateValueProcessor() {
        super();
    }

    public JsonUtilDateValueProcessor(String format) { // 自己需要的格式
        super();
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object value, JsonConfig paramJsonConfig) {
        return process(value);
    }

    @Override
    public Object processObjectValue(String key, Object value,
            JsonConfig paramJsonConfig) {
        return process(value);
    }

    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}
