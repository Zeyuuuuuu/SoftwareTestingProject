package com.songHuangCan.softwareTestingPrject.extractTestingMethod;


import com.songHuangCan.softwareTestingPrject.extractTestingMethod.annotation.TargetTestMethod;

/**
 * @Author yansong
 * @Date 11/04/2018 18:28
 *
 * 动态编译的实现可以参考
 *
 * 1. 从页面获取.java代码后，保存到一个地方 todo
 *      - 如何通过Spring boot 上传、保存文件
 * 2. 对这个文件进行编译
 * 3. 对这个文件所在文件夹进行扫描，获取class文件
 * 4. 通过URLClassLoader，扫描class文件所在目录，获取类的相关信息
 * 5. 获取类中所有的方法，并取出需要测试的类
 *      - 待测试的类需要被TargetTestMethod注解
 *        @see TargetTestMethod
 *      - 注意先取方法，再取注解
 * 6. 提供一个可以得到所有注解的方法
 *      @see CompilerExample
 */
public class DynamicCompiler {
}
