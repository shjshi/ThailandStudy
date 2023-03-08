package com.example.thailandstudy.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    // 读取json文件
    public static String getFromAssets(Context context, String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null)
                Result += line;
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //线程安全的
    private static final Gson GSON;
    private static final Gson GSON_NULL; // 不过滤空值

    static {
        GSON = new GsonBuilder().enableComplexMapKeySerialization() //当Map的key为复杂对象时,需要开启该方法
//                .serializeNulls() //当字段值为空或null时，依然对该字段进行转换
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//                .setPrettyPrinting() //自动格式化换行
                .disableHtmlEscaping() //防止特殊字符出现乱码
                .create();
        GSON_NULL = new GsonBuilder().enableComplexMapKeySerialization() //当Map的key为复杂对象时,需要开启该方法
                .serializeNulls() //当字段值为空或null时，依然对该字段进行转换
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//                .setPrettyPrinting() //自动格式化换行
                .disableHtmlEscaping() //防止特殊字符出现乱码
                .create();
    }

    /**
     * 将字符串转化对象
     *
     * @param json     源字符串
     * @param classOfT 目标对象类型
     * @param <T>
     * @return
     */
    public static <T> T strToJavaBean(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     * 获取List
     */
    public static <T> List<T> getDataList(String strJson, Class<T> clazz) {
        List<T> datalist = new ArrayList<>();
        Gson gson = new Gson();
        //        datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {}.getType());
        //改为下面的方法，clazz传入实际想要解析出来的类
        Type listType = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, clazz);
        datalist = gson.fromJson(strJson, listType);
        return datalist;
    }


}
