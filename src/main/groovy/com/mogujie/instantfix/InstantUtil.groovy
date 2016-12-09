package com.mogujie.instantfix

import com.mogujie.groovy.util.Utils
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * Created by wangzhi on 16/12/8.
 */
class InstantUtil {

    public static initFile(File dir, String name) {
        File file = new File(dir, name)
        Utils.initParentFile(file)
        file.delete()
        return file
    }

    public static def getAndroidSdkPath(Project project) {
        return "${project.android.getSdkDirectory()}/platforms/${project.android.getCompileSdkVersion()}/android.jar"
    }

    public static void copy(Project project, File src, File dstDir) {
        Utils.clearDir(dstDir)
        project.copy {
            from src
            into dstDir
            println "copy from ${src.absolutePath} to ${dstDir.absolutePath}"
        }
    }

    public static File getTaskOutApkFile(Task task) {
        File apk = task.outputs.files.files.find() { apk ->
            return apk.name.endsWith(".apk")
        }
        return apk
    }
}