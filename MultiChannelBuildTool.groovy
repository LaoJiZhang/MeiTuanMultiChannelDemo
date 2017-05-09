//Walle Cli
//GitHub地址： https://github.com/Meituan-Dianping/walle
//GitHub地址： https://github.com/Meituan-Dianping/walle/blob/master/walle-cli/README.md

def startTime = System.currentTimeMillis()
def channelFileName = "Channel.txt"

/**
 * @desc 遍历build目录文件夹下即将需要打包的Apk文件
 */
def originPath = new File("").getAbsolutePath() + File.separator
def apkPath = "app" + File.separator + "build" + File.separator + "outputs" + File.separator + "apk" + File.separator
File[] originApks = new File(originPath + apkPath).listFiles(new FilenameFilter() {
    @Override
    boolean accept(File file, String name) {
//        return name.endsWith(".apk")
        return name.contains("release") && name.endsWith(".apk")
    }
})

def targetPath = originPath + apkPath + "app_channel_target_apk" + File.separator
def targetDirFile = new File(targetPath)
if (!targetDirFile.exists()) {
    targetDirFile.mkdirs()
}

originApks.each { file ->
    new File(originPath + "app" + File.separator + channelFileName).eachLine { channel ->
        def newApkPath = targetPath + file.getName().replace(".apk", "-" + channel + ".apk")
        new File(newApkPath).delete()
        def singleCmd = "java -jar walle-cli-all.jar put -c " + channel + " " + file.getAbsolutePath() + " " + newApkPath
        Process process = singleCmd.execute()
        print "${process.text}"
    }
}
println "耗费时长：" + (System.currentTimeMillis() - startTime)