package com.example.mvvmapplication.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.constant.CommonUtils


abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract fun getToolbar(): Toolbar?
    private var mProgressDialog: ProgressDialog? = null
    /**
     * Method to replace the fragment. The [fragment] is added to the container view with id
     * [containerViewId] and a [tag]. The operation is performed by the supportFragmentManager.
     */
    fun AppCompatActivity.replaceFragmentSafelyInActivity(
        fragment: Fragment,
        tag: String,
        @IdRes containerViewId: Int,
        bundle: Bundle? = null,
        addBackStack: Boolean = false,
        allowStateLoss: Boolean = false,
        @AnimRes enterAnimation: Int = 0,
        @AnimRes exitAnimation: Int = 0,
        @AnimRes popEnterAnimation: Int = 0,
        @AnimRes popExitAnimation: Int = 0
    ) {

        fragment.setArguments(bundle)
        val ft = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
            .replace(containerViewId, fragment, tag)
        if (addBackStack) {
            ft.addToBackStack(tag)
        }
        if (!supportFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
    }

    /**
     * Method to replace the fragment. The [fragment] is added to the container view with id
     * [containerViewId] and a [tag]. The operation is performed by the supportFragmentManager.
     */
    fun AppCompatActivity.addFragmentSafelyInActivity(
        fragment: Fragment,
        tag: String,
        @IdRes containerViewId: Int,
        bundle: Bundle? = null,
        addBackStack: Boolean = false,
        allowStateLoss: Boolean = false,
        @AnimRes enterAnimation: Int = 0,
        @AnimRes exitAnimation: Int = 0,
        @AnimRes popEnterAnimation: Int = 0,
        @AnimRes popExitAnimation: Int = 0
    ) {

        fragment.setArguments(bundle)
        val ft = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnimation, exitAnimation, popEnterAnimation, popExitAnimation)
            .add(containerViewId, fragment, tag)
        if (addBackStack) {
            ft.addToBackStack(tag)
        }
        if (!supportFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
    }


    fun Toast.createToast(context: Context, message:String, gravity:Int, duration:Int){
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        /*first parameter is the layout you made
        second parameter is the root view in that xml
         */
        val layout = inflater.inflate(
            R.layout.custom_toast_layout,
            (context as Activity).findViewById<ViewGroup>(R.id.custom_toast_container))

        layout.findViewById<TextView>(R.id.text).text = message
//        setGravity(gravity, 0, 0)
        setDuration(Toast.LENGTH_LONG);
        setView(layout);
        show()
    }

    override fun showProgress() {
        hideProgress()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }
    override fun hideProgress() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }
}