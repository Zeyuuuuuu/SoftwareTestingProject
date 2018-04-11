package com.songHuangCan.softwareTestingPrject.extractTestingMethod;

import com.songHuangCan.softwareTestingPrject.extractTestingMethod.annotation.TargetTestMethod;

import javax.tools.*;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

/**
 * 一个编译运行的例子，详细思路见DynamicCompiler
 * @see DynamicCompiler
 * @Author yansong
 * @Date 11/04/2018 18:46
 */
public class CompilerExample {
    public static void example() {
        String fileToCompile = "/Users/yansong/Desktop/Test.java";

        // 获取JavaCompiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // DiagnosticListener用于获取Diagnostic信息，Diagnostic信息包括：错误，警告和说明性信息
        DiagnosticCollector diagnosticCollector = new DiagnosticCollector();

        // JavaFileManager:用于管理与工具有关的所有文件，这里的文件可以是内存数据，也可以是Socket数据，而不仅仅是磁盘文件。
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticCollector, Locale.ENGLISH, Charset.forName("utf-8"));
        // JavaFileObjects: 是java源码文件(.java)和class文件(.class)的抽象
        Iterable<? extends JavaFileObject> javaFileObjects = fileManager.getJavaFileObjects(fileToCompile);

        // 编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticCollector, null, null, javaFileObjects);
        Boolean result = task.call();

        System.out.println(result);

        List list = diagnosticCollector.getDiagnostics();
        for (Object object : list) {
            Diagnostic d = (Diagnostic) object;
            System.out.println(d.getMessage(Locale.ENGLISH));
        }

        URL[] urls= new URL[0];
        try {
            File file = new File("/Users/yansong/Desktop/");
            urls = new URL[]{file.toURI().toURL()};
            //通过URLClassLoader构造器生成myclassloader对象
            URLClassLoader myClassloader = new URLClassLoader(urls);
            Class cl= myClassloader.loadClass("Test");
            for (Method m :
                    cl.getMethods()) {
                System.out.println(m.getName() + " : " + m.isAnnotationPresent(TargetTestMethod.class));
            }
            System.out.println(cl.getAnnotations().length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
