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

fun swipeLayoutActivityKt(
        applicationPackage: String,
  packageName: String,
        activityClass: String,
  bindingName: String,
  layoutName: String
) = """
package ${packageName}

import android.os.Bundle

import dora.BaseActivity
import dora.widget.pull.SwipeLayout

import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingName}

class ${activityClass} : BaseActivity<${bindingName}>() {

	override fun getLayoutId(): Int {
    		return R.layout.${layoutName}
	}

	override fun initData(savedInstanceState: Bundle?, binding: ${bindingName}) {
     		TODO("Not yet implemented")
            // For Example:
            // binding.swipeLayout.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {
            //
            //     override fun onRefresh(swipeLayout: SwipeLayout) {
            //     }
            //
            //     override fun onLoadMore(swipeLayout: SwipeLayout) {
            //     }
            // })
	}
}
"""

fun swipeLayoutActivity(
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
import dora.widget.pull.SwipeLayout;

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
        // binding.swipeLayout.setOnSwipeListener(new SwipeLayout.OnSwipeListener() {
        //
	    //     @Override
        //     public void onRefresh(SwipeLayout swipeLayout) {
        //     }
	    //     
        //     @Override
        //     public void onLoadMore(SwipeLayout swipeLayout) {
        //     }
        // });
	}
}
"""
