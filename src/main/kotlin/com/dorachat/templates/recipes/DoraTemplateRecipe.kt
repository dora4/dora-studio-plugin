/*
 * Copyright (C) 2022 The Dora Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dorachat.templates.recipes

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.dorachat.templates.recipes.app_package.res.layout.mvvmActivityXml
import com.dorachat.templates.recipes.app_package.res.layout.mvvmFragmentXml
import com.dorachat.templates.recipes.app_package.src.mvvmActivity
import com.dorachat.templates.recipes.app_package.src.mvvmActivityKt
import com.dorachat.templates.recipes.app_package.src.mvvmFragment
import com.dorachat.templates.recipes.app_package.src.mvvmFragmentKt
import java.lang.StringBuilder

fun RecipeExecutor.mvvmActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        activityTitle: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData


    generateManifest(
            moduleData = moduleData,
            activityClass = activityClass,
//            activityTitle = activityTitle,
            packageName = packageName,
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false,

    )

    if (projectData.language.equals(Language.Kotlin)) {
        save(mvvmActivityKt(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    if (projectData.language.equals(Language.Java)) {
        save(mvvmActivity(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    save(mvvmActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.mvvmFragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    if (projectData.language.equals(Language.Kotlin)) {
        save(mvvmFragmentKt(projectData.applicationPackage ?: packageName, packageName, fragmentClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
    }
    if (projectData.language.equals(Language.Java)) {
        save(mvvmFragment(projectData.applicationPackage ?: packageName, packageName, fragmentClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
    }
    save(mvvmFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package Name"
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { packageName }
    }

/**
 * 将类名去掉最后一个类型的单词。
 */
fun buildClassNameWithoutSuffix(className: String, classNameSuffix: String): String {
    if (className.endsWith(classNameSuffix)) {
        return className.subSequence(0, className.length - classNameSuffix.length).toString()
    }
    return className
}

fun buildBindingName(layoutName: String) : String {
    val builder = StringBuilder()
    if (layoutName.contains("_")) {
        for (section in layoutName.split("_")) {
            builder.append(section[0].uppercaseChar()).append(section.subSequence(1, section.length))
        }
    }
    return builder.append("Binding").toString()
}