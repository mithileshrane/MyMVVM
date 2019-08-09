package com.example.mvvmapplication.ui.employeelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapplication.R
import com.example.mvvmapplication.base.BaseFragment
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.itgs.tradepartners.interfaces.IUpdateUI
import com.itgs.tradepartners.interfaces.OnClickListener
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.employee_list_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.util.concurrent.TimeUnit


class EmployeeListFragment : BaseFragment(), OnClickListener, IUpdateUI {

    var filteredPosts: MutableList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail> =
        mutableListOf()
    private val disposable = CompositeDisposable()

    override fun onLongClick(item: Any) {
        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle("Delete")
        builder.setMessage("Confirm?")
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(
                activity!!,
                android.R.string.yes, Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(
                activity!!,
                android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(
                activity!!,
                "Maybe", Toast.LENGTH_SHORT
            ).show()
        }
        builder.show()
    }

    override fun showRecordView() {


    }

    override fun showNoRecordView() {


    }

    override fun onClickItem(item: Any) {

    }


    companion object {
        fun newInstance() = EmployeeListFragment()
    }

    private var mainDocumentList: MutableList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail> =
        ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>()
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

        searchInput
            .textChanges()
            .debounce(200, TimeUnit.MILLISECONDS)
            .subscribe {
                search(it.toString())
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        val diffResult = DiffUtil.calculateDiff(PostsDiffUtilCallback(mainDocumentList, filteredPosts))
//                        mainDocumentList.clear()
                        mainDocumentList.addAll(filteredPosts)
                        diffResult.dispatchUpdatesTo(employeeListAdapterNew)
                    }.addTo(disposable)
            }.addTo(disposable)

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

    fun search(query: String): Completable = Completable.create {
        val wanted = mainDocumentList
            .filter {
                it.getFirstName()?.contains(query,true)!! || it.getLastName()?.contains(query,true)!!
                        || it.getDesignation()?.contains(query,true)!!
            }.toList()

        filteredPosts.clear()
        filteredPosts.addAll(wanted)
        it.onComplete()
    }

    private fun bindUI() = GlobalScope.launch(Dispatchers.Main) {
        try {

            viewModel._items.await().observe(this@EmployeeListFragment, Observer { planner ->
                if (planner == null) return@Observer
                mainDocumentList.clear()
                mainDocumentList.addAll(planner.toMutableList())//.filter { it.empId.toString() == SessionManager.getCurrentEmpID() }.toMutableList()
                employeeListAdapterNew.notifyDataSetChanged()

            })
        } catch (e: Exception) {
            e.message
        }
    }
}