package com.songHuangCan.softwareTestingPrject.extractTestingMethod.annotation;

import com.songHuangCan.softwareTestingPrject.extractTestingMethod.DynamicCompiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要测试的方法必须使用此注解
 * 注意包名 待优化 todo
 * 详细见DynamicCompiler
 * @see DynamicCompiler
 * @Author yansong
 * @Date 11/04/2018 18:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetTestMethod {
}
