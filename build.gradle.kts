
plugins {
    id("java")
    id("org.jetbrains.intellij") version("1.16.0")
    id("org.jetbrains.kotlin.jvm") version("1.9.10")
}

group = "com.dorachat"
version = "1.3"

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
//    version.set("231.9392.1.2311.10844163")
    version.set("202.7660.26.42.7486908")
    // Android Studio的代号是AI
    type.set("AI")
    plugins.set(listOf("Kotlin", "android"))
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("192")
        untilBuild.set("202.*")
        changeNotes.set("""
        <h3>1.3</h3>
      新增对MenuPanel的支持<br/>
        <h3>1.2</h3>
      新增对BaseVMActivity和BaseVMFragment的支持<br/>
        <h3>1.1</h3>
      initData()方法中增加databinding参数<br/>
        <h3>1.0</h3>
      初始版本，能够创建Java和Kotlin版本的MVVM Activiy和MVVM Fragment<br/>
      """)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    publishPlugin {
        token.set(System.getenv("ORG_GRADLE_PROJECT_intellijPublishToken"))
    }
    val javadocJar by registering(Jar::class) {
        archiveClassifier.set("javadoc")
    }

    val sourcesJar = register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    artifacts {
        archives(javadocJar)
        archives(sourcesJar)
    }

}
