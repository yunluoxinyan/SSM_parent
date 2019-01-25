package com.mabiao.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashunfeng on 17-8-21.
 */
public class URLEncodeUtil {
    private final static Log logger = LogFactory.getLog(URLEncodeUtil.class);


    public static String decode(String content, String charset){
        if(content == null){
            return null;
        }

        try {
            return URLDecoder.decode(content, charset);
        } catch (UnsupportedEncodingException e) {
            logger.error("url解码异常 conent["+content+"]  charset["+charset+"]",e);
        }

        return null;
    }

    public static String encode(String content,String charset){
        if(content == null){
            return null;
        }
        try {
            String str = URLEncoder.encode(content, charset);

            return str.replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            logger.error("编码异常 conent["+content+"]  charset["+charset+"]",e);
        }
        return null;
    }


    public static void main(String args[]) throws Exception {

        String s = "PORTS/宝姿 透明拼接100%羊毛针织衫毛衣女 LS9K574LKW002 紫罗兰 XS";
        String s1 = URLEncodeUtil.encode(s, "utf-8");
        System.out.println(URLEncodeUtil.decode(s, "UTF-8"));

    }
}
