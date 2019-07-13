package com.example.mvvmapplication.ui.employeelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.R
import com.example.mvvmapplication.base.BaseFragment
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.itgs.tradepartners.interfaces.IUpdateUI
import com.itgs.tradepartners.interfaces.OnClickListener
import kotlinx.android.synthetic.main.employee_list_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class EmployeeListFragment : BaseFragment(), OnClickListener, IUpdateUI {
    override fun showRecordView() {


    }

    override fun showNoRecordView() {


    }

    override fun onClickItem(item: Any) {

    }


    companion object {
        fun newInstance() = EmployeeListFragment()
    }

    private  var mainDocumentList: MutableList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>
            =ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>()
    private lateinit var viewModel: EmployeeListViewModel

    private lateinit var employeeListAdapterNew: EmployeeListAdapterNew

    private var listDetails: LiveData<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(EmployeeListViewModel::class.java)
        viewModel = getViewModel()

        viewModel.call()
        val mLayoutManager = LinearLayoutManager(activity!!)
        employeeListAdapterNew = EmployeeListAdapterNew(
            mainDocumentList as ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>
            , activity!!, this, this
        )
        recylView?.layoutManager = mLayoutManager
        recylView?.adapter = employeeListAdapterNew
        bindUI()
        /*viewModel._items.observe(this, Observer { result ->
            if (result != null) {
                employeeListAdapterNew = EmployeeListAdapterNew(
                    result.toList()
                            as ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>
                    , activity!!, this, this
                )
                recylView?.layoutManager = mLayoutManager
                recylView?.adapter = employeeListAdapterNew

            }
        })*/

    }

    private fun bindUI() = GlobalScope.launch(Dispatchers.Main) {
        try {

            viewModel._items.await().observe(this@EmployeeListFragment, Observer { planner ->
                if (planner == null) return@Observer
                mainDocumentList.clear()
                mainDocumentList.addAll(planner.toMutableList())//.filter { it.empId.toString() == SessionManager.getCurrentEmpID() }.toMutableList()
                employeeListAdapterNew.notifyDataSetChanged()

            })
        }catch (e:Exception){}
    }
}