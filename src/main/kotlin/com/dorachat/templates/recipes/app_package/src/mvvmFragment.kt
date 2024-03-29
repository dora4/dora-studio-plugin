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

fun mvvmFragmentKt(
        applicationPackage: String,
  packageName: String,
        fragmentClass: String,
        viewModelClass: String,
  bindingName: String,
  layoutName: String
) = """
package ${packageName}

import android.os.Bundle

import dora.BaseVMFragment

import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingName}
import ${packageName}.viewmodel.${viewModelClass}

class ${fragmentClass} : BaseVMFragment<${bindingName}, ${viewModelClass}>() {

	override fun getLayoutId(): Int {
    		return R.layout.${layoutName}
	}

	override fun initData(savedInstanceState: Bundle?, binding: ${bindingName}) {
            super.initData(savedInstanceState, binding)
     		TODO("Not yet implemented")
	}
}
"""

fun mvvmFragment(
        applicationPackage: String,
        packageName: String,
        fragmentClass: String,
        viewModelClass: String,
        bindingName: String,
        layoutName: String
) = """
package ${packageName};

import android.os.Bundle;
import androidx.annotation.Nullable;

import dora.BaseVMFragment;

import ${applicationPackage}.R;
import ${applicationPackage}.databinding.${bindingName};
import ${packageName}.viewmodel.${viewModelClass}

public class ${fragmentClass} extends BaseVMFragment<${bindingName}, ${viewModelClass}> {

	@Override
    protected int getLayoutId() {
        return R.layout.${layoutName};
    }

	@Override
    public void initData(@Nullable Bundle savedInstanceState, ${bindingName} binding) {
        super.initData(savedInstanceState, binding);
        // TODO: Not yet implemented
	}
}
"""
