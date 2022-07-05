package com.gb.m_2090_3.view.layouts.behaviors

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import com.gb.m_2090_3.R
import com.google.android.material.appbar.AppBarLayout

class NestedBehavior(context: Context, attrs: AttributeSet? = null) :
    CoordinatorLayout.Behavior<NestedScrollView>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: NestedScrollView,
        dependency: View
    ): Boolean {
        //return (dependency.id == R.id.appBar)
        return dependency is AppBarLayout
    }


    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: NestedScrollView,
        dependency: View
    ): Boolean {
        if (dependency is AppBarLayout) {
            Log.d("@@@", "${dependency.y} ${dependency.height}")
            child.y = dependency.y + dependency.height
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }
}