package com.snowwave.concurrency.reflectionDemo;

import java.io.*;

/**
 * Created by zhangfuqiang on 2019/5/19.
 */
public class MyClassLoader extends ClassLoader {

    private String path;
    private String classLoaderName;

    public MyClassLoader(String path,String classLoaderName){
        this.path = path;
        this.classLoaderName = classLoaderName;
    }
    //用于寻找类文件
    @Override
    protected Class<?> findClass(String name)  {
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name,b,0,b.length);
    }

    //用于加载类文件
    private byte[] loadClassData(String name) throws Exception{
        name = path + name + ".class";
        InputStream in =  in = new FileInputStream(new File(name));
        ByteArrayOutputStream out = out = new ByteArrayOutputStream();
        int i = 0 ;
        while ((i = in.read()) != -1){
            out.close();
            in.close();
        }
        return out.toByteArray();
    }
}
