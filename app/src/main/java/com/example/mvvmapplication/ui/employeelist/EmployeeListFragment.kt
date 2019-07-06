package com.example.mvvmapplication.ui.employeelist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmapplication.R
import com.example.mvvmapplication.base.BaseFragment


class EmployeeListFragment : BaseFragment() {


    companion object {
        fun newInstance() = EmployeeListFragment()
    }

    private lateinit var viewModel: EmployeeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EmployeeListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
