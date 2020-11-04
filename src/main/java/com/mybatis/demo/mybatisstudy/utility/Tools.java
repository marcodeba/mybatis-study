package com.mybatis.demo.mybatisstudy.utility;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {

    public static void generateSourceCode(Class clazz) {
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{clazz});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(clazz.getResource("").getPath() + "/$Proxy0.class");
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
