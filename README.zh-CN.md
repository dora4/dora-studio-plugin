<a href="./README.zh-CN.md">简体中文</a> ｜ <a href="./README.md">English</a>

# Android Studio 插件 - Dora SDK

![product](https://github.com/dora4/dora-studio-plugin/blob/main/art/product.png)

**IDEA下载**

首先，你可能需要下载**IntelliJ IDEA**以支持此项目的编译，因为你的Android Studio可能会无法成功编译此项目。

**JAR包下载**

下载最新版本（v1.2）的插件包，开箱（棺）即用。

<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/'>插件jar包集合</a>，如果没有你正在使用
的Android Studio的版本，请自行编译或下载跟插件相同版本的Android Studio，https://developer.android.com/studio/archive?hl=en 。

**插件安装**

![install-jar](https://github.com/dora4/dora-studio-plugin/blob/main/art/install-jar.png)

**使用步骤**

![step1](https://github.com/dora4/dora-studio-plugin/blob/main/art/step1.png)

![step2](https://github.com/dora4/dora-studio-plugin/blob/main/art/step2.png)

**如何编译**

依次点击[Android Studio] - [About Android Studio]可以查看当前使用的Android Studio版本号。

```groovy
intellij {
    plugins = ['Kotlin', 'android']
    // 参考 https://plugins.jetbrains.com/docs/intellij/android-studio.html#android-studio-releases-listing
    // 填入你的Android Studio版本，如232.10227.8.2321.11203637
    version.set("213.7172.25.2113.9014738")
    // Android Studio的代号是AI
    type.set("AI")
}
```
保证上述代码中的版本号跟你实际使用的Android Studio一致。然后Edit Configrations，选择Gradle，点击OK，接下来就可以编译插件了。插件生成目录为 dora-studio-plugin/build/libs/ 。

**为什么要使用此插件**

此插件服务于Dora SDK框架，提升Dora SDK的开发效率。
也看Dora SDK（ https://github.com/dora4/dora ）的使用教程。

**特别鸣谢**

https://github.com/JetBrains/gradle-intellij-plugin/

https://github.com/JetBrains/intellij-platform-plugin-template

https://github.com/cookpad/android-studio-templates

https://github.com/balsikandar/Android-Studio-Plugins
