<a href="./README.zh-CN.md">简体中文</a> ｜ <a href="./README.md">English</a>

# Android Studio Plugin for Dora SDK

![product](https://github.com/dora4/dora-studio-plugin/blob/main/art/product.png)

**IDEA Download**

First, you may need to download IntelliJ IDEA to support the compilation of this project, as your Android Studio may not be able to compile this project successfully.
See https://www.yuque.com/u27500190/vsecth/rpc3t84gskftrz06.

**JAR Package Download**

Download the plugin package for the latest version (v1.2), and it's ready to use.

<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/'>Plugin JAR Package Collection</a>, if your version of Android Studio is not available, please compile it yourself or download the version of Android Studio that matches the plugin, https://developer.android.com/studio/archive?hl=en.

**Plugin Installation**

![install-jar](https://github.com/dora4/dora-studio-plugin/blob/main/art/install-jar.png)

**Usage Steps**

![step1](https://github.com/dora4/dora-studio-plugin/blob/main/art/step1.png)

![step2](https://github.com/dora4/dora-studio-plugin/blob/main/art/step2.png)

**How to Compile**

Click [Android Studio] - [About Android Studio] to view the current version of Android Studio.

```groovy
intellij {
    plugins = ['Kotlin', 'android']
    // See https://plugins.jetbrains.com/docs/intellij/android-studio.html#android-studio-releases-listing
    // Enter your Android Studio version, such as 232.10227.8.2321.11203637
    version.set("213.7172.25.2113.9014738")
    // The codename for Android Studio is AI
    type.set("AI")
}
```

Ensure that the version number in the above code matches the version of Android Studio you are using. Then, go to Edit Configurations, select Gradle, click OK, and you can now compile the plugin. The plugin's build directory is dora-studio-plugin/build/libs/.

**Why Use This Plugin**

This plugin serves the Dora SDK framework, enhancing the development efficiency of the Dora SDK. Also, refer to the Dora SDK (https://github.com/dora4/dora) usage tutorial.

**Special Thanks**

https://github.com/JetBrains/gradle-intellij-plugin/

https://github.com/JetBrains/intellij-platform-plugin-template

https://github.com/cookpad/android-studio-templates

https://github.com/balsikandar/Android-Studio-Plugins
