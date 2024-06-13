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
import com.dorachat.templates.recipes.app_package.res.layout.dataBindingActivityXml
import com.dorachat.templates.recipes.app_package.res.layout.dataBindingFragmentXml
import com.dorachat.templates.recipes.app_package.res.layout.menuPanelActivityXml
import com.dorachat.templates.recipes.app_package.res.layout.swipeLayoutActivityXml
import com.dorachat.templates.recipes.app_package.src.dataBindingActivity
import com.dorachat.templates.recipes.app_package.src.dataBindingActivityKt
import com.dorachat.templates.recipes.app_package.src.dataBindingFragment
import com.dorachat.templates.recipes.app_package.src.dataBindingFragmentKt
import com.dorachat.templates.recipes.app_package.src.menuPanelActivity
import com.dorachat.templates.recipes.app_package.src.menuPanelActivityKt
import com.dorachat.templates.recipes.app_package.src.mvvmActivity
import com.dorachat.templates.recipes.app_package.src.mvvmActivityKt
import com.dorachat.templates.recipes.app_package.src.mvvmFragment
import com.dorachat.templates.recipes.app_package.src.mvvmFragmentKt
import com.dorachat.templates.recipes.app_package.src.swipeLayoutActivity
import com.dorachat.templates.recipes.app_package.src.swipeLayoutActivityKt
import com.dorachat.templates.recipes.app_package.src.viewModel
import com.dorachat.templates.recipes.app_package.src.viewModelKt
import java.io.File
import java.lang.StringBuilder

fun RecipeExecutor.dataBindingActivityRecipe(
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
            generateActivityTitle = false
    )

    if (projectData.language == Language.Kotlin) {
        save(dataBindingActivityKt(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(dataBindingActivity(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    save(dataBindingActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.menuPanelActivityRecipe(
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
            generateActivityTitle = false
    )

    if (projectData.language == Language.Kotlin) {
        save(
            menuPanelActivityKt(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(menuPanelActivity(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    save(menuPanelActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.swipeLayoutActivityRecipe(
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
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )

    if (projectData.language == Language.Kotlin) {
        save(
            swipeLayoutActivityKt(projectData.applicationPackage ?: packageName, packageName, activityClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(swipeLayoutActivity(projectData.applicationPackage ?: packageName, packageName, activityClass,
            buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
    }
    save(swipeLayoutActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.mvvmActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        viewModelClass: String,
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
            generateActivityTitle = false

    )
    val viewModelDir = File(srcOut, "viewmodel")
    if (!viewModelDir.exists()) {
        viewModelDir.mkdir()
    }
    if (projectData.language == Language.Kotlin) {
        save(mvvmActivityKt(projectData.applicationPackage ?: packageName, packageName, activityClass, viewModelClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
        save(viewModelKt(packageName,
                viewModelClass), viewModelDir.resolve("${viewModelClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(mvvmActivity(projectData.applicationPackage ?: packageName, packageName, activityClass, viewModelClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${activityClass}.${projectData.language.extension}"))
        save(viewModel(packageName,
                viewModelClass), viewModelDir.resolve("${viewModelClass}.${projectData.language.extension}"))

    }
    save(dataBindingActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.dataBindingFragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    if (projectData.language == Language.Kotlin) {
        save(dataBindingFragmentKt(projectData.applicationPackage ?: packageName, packageName, fragmentClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(dataBindingFragment(projectData.applicationPackage ?: packageName, packageName, fragmentClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
    }
    save(dataBindingFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))

    open(resOut.resolve("layout/${layoutName}.xml"))

}

fun RecipeExecutor.mvvmFragmentRecipe(
        moduleData: ModuleTemplateData,
        fragmentClass: String,
        viewModelClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val viewModelDir = File(srcOut, "viewmodel")
    if (!viewModelDir.exists()) {
        viewModelDir.mkdir()
    }
    if (projectData.language == Language.Kotlin) {
        save(mvvmFragmentKt(projectData.applicationPackage ?: packageName, packageName, fragmentClass, viewModelClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
        save(viewModelKt(packageName,
                viewModelClass), viewModelDir.resolve("${viewModelClass}.${projectData.language.extension}"))
    }
    if (projectData.language == Language.Java) {
        save(mvvmFragment(projectData.applicationPackage ?: packageName, packageName, fragmentClass, viewModelClass,
                buildBindingName(layoutName), layoutName), srcOut.resolve("${fragmentClass}.${projectData.language.extension}"))
        save(viewModel(packageName,
                viewModelClass), viewModelDir.resolve("${viewModelClass}.${projectData.language.extension}"))
    }
    save(dataBindingFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))

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
