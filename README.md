# Android Studio Plugin for Dora

![product](https://github.com/dora4/dora-studio-plugin/blob/main/art/product.png)



**jar包下载**

1.0版本（必须跟你的Android Studio版本对应）
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.0.0_213.7172.25.2113.9123335.jar'>dora-studio-plugin-1.0.0_213.7172.25.2113.9123335.jar</a>
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.0.0_222.4459.24.2221.9971841.jar'>dora-studio-plugin-1.0.0_222.4459.24.2221.9971841.jar</a>

1.1版本jar包
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.1.jar'>dora-studio-plugin-1.1.jar</a>

1.1版本源码包
<a href='https://github.com/dora4/dora-studio-plugin/blob/main/art/dora-studio-plugin-1.1-sources.jar'>dora-studio-plugin-1.1-sources.jar</a>


依次点击[Android Studio] - [About Android Studio]可以查看当前使用的Android Studio版本号，如果没有你要的插件版本，你可以自行打包编译。注意修改以下配置。

```groovy
// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    plugins = ['Kotlin', 'android']
    version.set("你的Android Studio版本，如213.7172.25.2113.9123335")
    // Android Studio的代号是AI
    type.set("AI")
}
```

然后Edit Configrations，选择Gradle，点OK，然后就可以编译插件了，插件生成目录为dora-studio-plugin/build/libs/。

**插件安装**

![install-jar](https://github.com/dora4/dora-studio-plugin/blob/main/art/install-jar.png)

**使用步骤**

![step1](https://github.com/dora4/dora-studio-plugin/blob/main/art/step1.png)

![step2](https://github.com/dora4/dora-studio-plugin/blob/main/art/step2.png)

也看 https://github.com/dora4/dora 的使用教程



**特别鸣谢**

https://github.com/JetBrains/intellij-platform-plugin-template

https://github.com/cookpad/android-studio-templates

https://github.com/balsikandar/Android-Studio-Plugins
