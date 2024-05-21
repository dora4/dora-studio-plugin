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

object MVVMFragmentTemplate : Template {
    override val category: Category
        get() = Category.Fragment
    override val constraints: Collection<TemplateConstraint>
        get() = emptyList()     // AndroidX, kotlin
    override val description: String
        get() = "创建一个dora.BaseVMFragment，来自https://github.com/dora4/dora"
    override val documentationUrl: String?
        get() = null
    override val formFactor: FormFactor
        get() = FormFactor.Mobile
    override val minCompileSdk: Int
        get() = MIN_API
    override val minSdk: Int
        get() = MIN_API
    override val name: String
        get() = "MVVM Fragment"
    override val recipe: Recipe
        get() = {
            mvvmFragmentRecipe(
                    it as ModuleTemplateData,
                    fragmentClassInputParameter.value,
                    viewModelInputParameter.value,
                    layoutNameInputParameter.value,
                    packageName.value
            )
        }
    override val revision: Int
        get() = TODO("Not yet implemented")
    override val uiContexts: Collection<WizardUiContext>
        get() = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)
    override val widgets: Collection<Widget<*>>
        get() = listOf(
                TextFieldWidget(fragmentTitleInputParameter),
                TextFieldWidget(fragmentClassInputParameter),
                TextFieldWidget(viewModelInputParameter),
                TextFieldWidget(layoutNameInputParameter),
                PackageNameWidget(packageName),
                LanguageWidget()
        )

    override fun thumb(): Thumb {
        return Thumb { findResource(this.javaClass, File("template_fragment.png")) }
    }

    val fragmentClassInputParameter = stringParameter {
        name = "Fragment Name"
        default = "MainFragment"
        help = "The name of the fragment class to create"
        constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { layoutToFragment(layoutNameInputParameter.value) }
    }

    var viewModelInputParameter: StringParameter = stringParameter {
        name = "ViewModel Name"
        default = "MainViewModel"
        help = "The name of the ViewModel"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { buildClassNameWithoutSuffix(fragmentClassInputParameter.value, "Fragment") + "ViewModel" }
    }

    var layoutNameInputParameter: StringParameter = stringParameter {
        name = "Layout Name"
        default = "fragment_main"
        help = "The name of the layout to create for the fragment"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { fragmentToLayout(fragmentClassInputParameter.value) }
    }

    val fragmentTitleInputParameter = stringParameter {
        name = "Title"
        default = "Main"
        help = "The name of the fragment. For launcher fragments, the application title"
        visible = { false }
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { buildClassNameWithoutSuffix(fragmentClassInputParameter.value, "Fragment") }
    }
    val packageName = defaultPackageNameParameter
}
