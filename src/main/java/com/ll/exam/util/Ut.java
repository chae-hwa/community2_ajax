package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

public class Ut {
    public static class json {
        private static final ObjectMapper om;

        static{
            om = new ObjectMapper();
        }
        public static String toStr(Object obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj); // 자바 객체를 json으로 (문자열로)변환
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> T toObj(String jsonStr, Class<T> cls, T defaultValue) {
            try {
                return (T)om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    };
}
