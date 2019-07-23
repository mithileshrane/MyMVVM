package com.example.mvvmapplication.ui.employeelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapplication.R
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.itgs.tradepartners.interfaces.IUpdateUI
import com.itgs.tradepartners.interfaces.OnClickListener

class EmployeeListAdapterNew(
    val list: ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>,
    val context: Context,
    val listener: OnClickListener,
    val uiUpdateListener: IUpdateUI
) : RecyclerView.Adapter<EmployeeListAdapterNew.DataHolder>(), Filterable {

    var filteredList = list


//    filterList.addAll(items)


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmployeeListAdapterNew.DataHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.employee_list_row, parent, false)

        return EmployeeListAdapterNew.DataHolder(v)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: EmployeeListAdapterNew.DataHolder, position: Int) {
        val employeeListModel = filteredList.get(position)

//        Glide.with(context)
//            .load(APIConstants.RELATIVE_URL + employeeListModel.Image)
//            .centerCrop()
//            .placeholder(R.mipmap.default_profile_img)
//            .error(R.mipmap.default_profile_img)
//            .into(holder.iv_employee_img);

        // Setting font
//        App.setTypeFace()
//        holder.tv_employee_name.typeface = App.getRobotoMediumTypeFace()!!

        /* // Setting Image
         GlideApp.with(context)
             .load(*//*APIConstants.RELATIVE_URL + *//*employeeListModel.getImage())
            .placeholder(R.drawable.ic_man_user)
            .error(R.drawable.ic_man_user)
//            .apply(RequestOptions().transform(CircleTransform(context)))
            .into(holder.iv_employee_img)*/

        holder.tv_employee_name.text =
            (employeeListModel.getFirstName()?.toString() + " " + employeeListModel.getLastName()?.toString())
        holder.tv_employee_designation.text = employeeListModel.getDesignation()
        /*  if(employeeListModel.getIsTrackAllow()!!){
              holder.tv_tracking_status.text = "Tracking Disabled"
          }else{
              holder.tv_tracking_status.text = "Tracking Enabled"
          }*/
        holder.tvHolder.setOnClickListener { listener.onClickItem(employeeListModel) }
        holder.tvHolder.setOnLongClickListener {
            listener.onLongClick(employeeListModel)

            return@setOnLongClickListener true
        }

        /* if (items.size - 1 == position)
             holder.tvNavDividerline.visibility = View.INVISIBLE*/
    }


    class DataHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder) {
        val iv_employee_img = itemView.findViewById<ImageView>(R.id.iv_employee_img)
        val tv_employee_name = itemView.findViewById<TextView>(R.id.tv_employee_name)
        val tv_tracking_status = itemView.findViewById<TextView>(R.id.tv_tracking_status)
        val tv_employee_designation = itemView.findViewById<TextView>(R.id.tv_employee_designation)
        val tvNavDividerline = itemView.findViewById<View>(R.id.divider_line)
        val tvHolder = itemViewHolder

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    filteredList = list
                } else {
                    val filteredListNew =
                        ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>()
                    for (row in list) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getFirstName()!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredListNew.add(row)
                        } else if (row.getFirstName()!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredListNew.add(row)
                        }

                    }

                    filteredList = filteredListNew
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                filteredList =
                    filterResults.values as ArrayList<EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail>
                notifyDataSetChanged()
                if (filteredList.size == 0)
                    uiUpdateListener.showNoRecordView()
                else
                    uiUpdateListener.showRecordView()
            }
        }
    }


}