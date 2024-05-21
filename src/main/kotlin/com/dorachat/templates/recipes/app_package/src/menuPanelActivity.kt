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

package com.dorachat.templates.recipes.app_package.src

fun menuPanelActivityKt(
        applicationPackage: String,
  packageName: String,
        activityClass: String,
  bindingName: String,
  layoutName: String
) = """
package ${packageName}

import android.os.Bundle

import dora.BaseActivity

import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingName}

class ${activityClass} : BaseActivity<${bindingName}>() {

	override fun getLayoutId(): Int {
    		return R.layout.${layoutName}
	}

	override fun initData(savedInstanceState: Bundle?, binding: ${bindingName}) {
     		TODO("Not yet implemented")
            // For Example:
            // binding.menuPanel.addMenuGroup(
            //     MenuPanelItemGroup(
            //         DensityUtils.dp2px(10f),
            //         NormalMenuPanelItem("menuName", "text", true, "arrowText")
            //     )
            // )
	}
}
"""

fun menuPanelActivity(
        applicationPackage: String,
        packageName: String,
        activityClass: String,
        bindingName: String,
        layoutName: String
) = """
package ${packageName};

import android.os.Bundle;
import androidx.annotation.Nullable;

import dora.BaseActivity;

import ${applicationPackage}.R;
import ${applicationPackage}.databinding.${bindingName};

public class ${activityClass} extends BaseActivity<${bindingName}> {

	@Override
    protected int getLayoutId() {
        return R.layout.${layoutName};
    }

	@Override
    public void initData(@Nullable Bundle savedInstanceState, ${bindingName} binding) {
        // TODO: Not yet implemented
        // For Example:
        // binding.menuPanel.addMenuGroup(
        //     new MenuPanelItemGroup(
        //         DensityUtils.dp2px(10f),
        //         new NormalMenuPanelItem("menuName", "text", true, "arrowText")
        //     )
        // );
	}
}
"""
