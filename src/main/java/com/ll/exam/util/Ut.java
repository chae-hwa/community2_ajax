package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class json {
        public static String toStr(Object obj, String defaultValue) {
            ObjectMapper om = new ObjectMapper();

            try {
                return om.writeValueAsString(obj); // 자바 객체를 json으로 (문자열로)변환
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    };
}
