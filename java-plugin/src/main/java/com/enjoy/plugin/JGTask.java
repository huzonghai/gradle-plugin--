package com.enjoy.plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

import java.io.File;

import javax.inject.Inject;


public class JGTask extends DefaultTask {
    private final File apk;
    private final JGExt jGExt;

    @Inject
    public JGTask(File apk, JGExt jGExt) {
        this.apk = apk;
        this.jGExt = jGExt;
        //设置任务的分组
        setGroup("jiagu");
    }


    @TaskAction
    public void performTask() {
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", jGExt.getJiaGuToolPath(), "-login",
                        jGExt.getUsername(), jGExt.getPassword());
            }
        });

        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", jGExt.getJiaGuToolPath(), "-importsign",
                        jGExt.getKeyStorePath(), jGExt.getKeyStorePass(),
                        jGExt.getKeyStoreKeyAlias(), jGExt.getKeyStoreKeyAliasPwd());
            }
        });

        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java", "-jar", jGExt.getJiaGuToolPath(), "-jiagu",
                        apk.getAbsolutePath(),apk.getParentFile().getAbsolutePath(),"-autosign");
            }
        });
    }
}
