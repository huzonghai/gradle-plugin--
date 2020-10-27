package com.enjoy.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariantOutput;

import org.gradle.api.Action;
import org.gradle.api.DomainObjectCollection;
import org.gradle.api.DomainObjectSet;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;

/**
 * 需要依赖Gradle,AS2.4以上自带，则无需依赖
 * 这里实现自动调用360加固功能
 */
public class JPlugin implements Plugin<Project> {
    /**
     * @param project Java插件扩展 （类似Android项目gradle中'android'配置等等）
     */
    @Override
    public void apply(Project project) {
        final JGExt jiaGu = project.getExtensions()
                .create("jiagu", JGExt.class);

        //等到app build.gradle编译完成,回调
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(final Project project) {
                String jiaGuUsername = jiaGu.getUsername();
                System.err.println("jiaGuInfo = " + jiaGu.toString());

                //动态获取编译目标（debug/release）的APK文件
                //先获取Android官方插件（com.android.application）的扩展（android） 官方插件生产的APK文件
                AppExtension android = (AppExtension) project.getExtensions().getByName("android");
                //变种 1.debug 2.release
                DomainObjectSet<ApplicationVariant> applicationVariants = android.getApplicationVariants();
                applicationVariants.all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant variant) {
                        //debug/release
                        final String variantName = variant.getName();
                        System.err.println("variantName = " + variantName);
                        DomainObjectCollection<BaseVariantOutput> outputs = variant.getOutputs();
                        outputs.all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput baseVariantOutput) {
                                //apk文件
                                File outputFile = baseVariantOutput.getOutputFile();
                                //创建任务组双击进行加固
                                //加固规则行为则有实体配置JGTask生产 ,文件以及参数传入
                                project.getTasks().create("jiagu"+variantName
                                        ,com.enjoy.plugin.JGTask.class
                                        ,outputFile
                                        ,jiaGu);
                            }
                        });

                    }
                });

            }
        });
    }
}
