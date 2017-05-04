# MeiTuanMultiChannelDemo
利用美团新一代V2打包方案实现项目多渠道打包

使用Groovy脚本自动生成渠道包，

使用步骤：

* 在AndroidStudio 利用插件生成原始release包
* 在Terminal控制台执行 ./MultiChannel.sh 命令即可

###使用注意事项：
复制以下文件放置在您项目对应位置即可：（需注意需要您本地存在groovy运行环境即可）

 * app/Channel.txt
 * MultiChannel.sh
 * MultiChannelBuildTool.groovy
 * walle-cli-all.jar