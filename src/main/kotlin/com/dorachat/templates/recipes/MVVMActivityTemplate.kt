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
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import java.io.File

object MVVMActivityTemplate : Template {
    override val category: Category
        get() = Category.Activity
    override val constraints: Collection<TemplateConstraint>
        get() = emptyList()     // AndroidX, kotlin
    override val description: String
        get() = "创建一个dora.BaseVMActivity，来自https://github.com/dora4/dora"
    override val documentationUrl: String?
        get() = null
    override val formFactor: FormFactor
        get() = FormFactor.Mobile
    override val minSdk: Int
        get() = MIN_API
    override val name: String
        get() = "MVVM Activity"
    override val recipe: Recipe
        get() = {
            mvvmActivityRecipe(
                    it as ModuleTemplateData,
                    activityClassInputParameter.value,
                    viewModelInputParameter.value,
                    activityTitleInputParameter.value,
                    layoutNameInputParameter.value,
                    packageName.value
            )
        }
    override val uiContexts: Collection<WizardUiContext>
        get() = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)
    override val useGenericInstrumentedTests: Boolean
        get() = false
    override val useGenericLocalTests: Boolean
        get() = false
    override val widgets: Collection<Widget<*>>
        get() = listOf(
                TextFieldWidget(activityTitleInputParameter),
                TextFieldWidget(activityClassInputParameter),
                TextFieldWidget(viewModelInputParameter),
                TextFieldWidget(layoutNameInputParameter),
                PackageNameWidget(packageName),
                LanguageWidget()
        )

    override fun thumb(): Thumb {
        return Thumb { findResource(this.javaClass, File("template_activity.png")) }
    }

    val activityClassInputParameter = stringParameter {
        name = "Activity Name"
        default = "MainActivity"
        help = "The name of the activity class to create"
        constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { layoutToActivity(layoutNameInputParameter.value) }
    }

    var viewModelInputParameter: StringParameter = stringParameter {
        name = "ViewModel Name"
        default = "MainViewModel"
        help = "The name of the ViewModel"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { buildClassNameWithoutSuffix(activityClassInputParameter.value, "Activity") + "ViewModel" }
    }

    var layoutNameInputParameter: StringParameter = stringParameter {
        name = "Layout Name"
        default = "activity_main"
        help = "The name of the layout to create for the activity"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { activityToLayout(activityClassInputParameter.value) }
    }

    val activityTitleInputParameter = stringParameter {
        name = "Title"
        default = "Main"
        help = "The name of the activity. For launcher activities, the application title"
        visible = { false }
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { buildClassNameWithoutSuffix(activityClassInputParameter.value, "Activity") }
    }
    val packageName = defaultPackageNameParameter
}
