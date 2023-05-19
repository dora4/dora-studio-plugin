/*
 * Copyright (C) 2022 The Android Open Source Project
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
  bindingName: String,
  layoutName: String,
) = """
package ${packageName}

import android.os.Bundle

import dora.BaseFragment

import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingName}

class ${fragmentClass} : BaseFragment<${bindingName}>() {

	override fun getLayoutId(): Int {
    		return R.layout.${layoutName}
	}

	override fun initData(savedInstanceState: Bundle?) {
     		TODO("Not yet implemented")
	}
}
"""

fun mvvmFragment(
        applicationPackage: String,
        packageName: String,
        fragmentClass: String,
        bindingName: String,
        layoutName: String,
) = """
package ${packageName};

import android.os.Bundle;

import dora.BaseFragment;

import ${applicationPackage}.R;
import ${applicationPackage}.databinding.${bindingName};

public class ${fragmentClass} extends BaseFragment<${bindingName}> {

	@Override
    protected int getLayoutId() {
        return R.layout.${layoutName};
    }

	@Override
    public void initData(Bundle savedInstanceState) {
        // TODO: Not yet implemented
	}
}
"""
