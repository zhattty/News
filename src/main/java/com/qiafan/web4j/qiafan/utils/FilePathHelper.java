package com.qiafan.web4j.qiafan.utils;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 21:47
 */
public class FilePathHelper {
    public static String getRelativePathByFileName(String fileName) throws Exception {
        if(fileName == null){
            throw new Exception("fileName connot be null");
        }
        int i = fileName.hashCode();
        char[] chars = Integer.toHexString(i).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar).append("/");
        }
        return stringBuilder.toString();
    }
}
