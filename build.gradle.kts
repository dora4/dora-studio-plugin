
plugins {
    id("java")
    id("org.jetbrains.intellij") version("1.16.0")
    id("org.jetbrains.kotlin.jvm") version("1.9.10")
}

group = "com.dorachat"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

//java {
//    sourceCompatibility = JavaVersion.VERSION_17
//}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
//    version.set("231.9392.1.2311.10844163")
    version.set("223.8836.35.2231.10406996")
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
        sinceBuild.set("223")
        untilBuild.set("232.*")
        changeNotes.set("""
        <h3>1.1</h3>
      initData()方法中增加databinding参数<br/>
        <h3>1.0.0</h3>
      初始版本，能够创建Java和Kotlin版本的MVVMActiviy和MVVMFragment<br/>
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
}
