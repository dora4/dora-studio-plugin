# Android Studio Plugin for Dora SDK

![product](https://github.com/dora4/dora-studio-plugin/blob/main/art/product.png)

**IDEA下载**

首先，你可能需要下载**IntelliJ IDEA**以支持此项目的编译，因为你的Android Studio可能会无法成功编译此项目。

**JAR包下载**

下载最新版本（v1.2）的插件包，开箱（棺）即用

jar包：
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.2.jar'>dora-studio-plugin-1.2.jar</a>

javadoc：
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.2-javadoc.jar'>dora-studio-plugin-1.2-javadoc.jar</a>

源码包：
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.2-sources.jar'>dora-studio-plugin-1.2-sources.jar</a>

**插件安装**

![install-jar](https://github.com/dora4/dora-studio-plugin/blob/main/art/install-jar.png)

**使用步骤**

![step1](https://github.com/dora4/dora-studio-plugin/blob/main/art/step1.png)

![step2](https://github.com/dora4/dora-studio-plugin/blob/main/art/step2.png)

**如何编译**

你也可以通过源代码自行编译jar文件。具体步骤如下：
依次点击[Android Studio] - [About Android Studio]可以查看当前使用的Android Studio版本号。

```groovy
// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    plugins = ['Kotlin', 'android']
    version.set("你的Android Studio版本，如213.7172.25.2113.9123335")
    // Android Studio的代号是AI
    type.set("AI")
}
```
保证上述代码中的版本号跟你实际使用的Android Studio一致。然后Edit Configrations，选择Gradle，点击OK，接下来就可以编译插件了。插件生成目录为 dora-studio-plugin/build/libs/ 。

**为什么要使用此插件**

此插件服务于Dora SDK框架，提升Dora SDK的开发效率。
也看Dora SDK（https://github.com/dora4/dora）的使用教程。

**特别鸣谢**

https://github.com/JetBrains/intellij-platform-plugin-template

https://github.com/cookpad/android-studio-templates

https://github.com/balsikandar/Android-Studio-Plugins
