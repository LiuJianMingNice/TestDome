package com.yicooll.wanandroidkotlin.ui.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.ui.activity.ArticalSystemActivity
import com.example.kotlinprojection.wanandroid.ui.activity.OfficialCodeActivity
import com.example.kotlinprojection.wanandroid.ui.activity.ProjectActivity
import com.example.kotlinprojection.wanandroid.ui.activity.SearchActivity
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.entity.Template
import kotlinx.android.synthetic.main.wan_item_of_block_list.view.*

class IndexBlockAdapter(context: Context, data: List<Template>) : RecyclerView.Adapter<IndexBlockAdapter.ViewHolder>() {

    private var context: Context? = null
    private val templateList = ArrayList<Template>()

    init {
        this.context = context
        this.templateList.clear()
        this.templateList.addAll(data)
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.wan_item_of_block_list, parent, false))
    }

    override fun getItemCount(): Int {
        return templateList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(templateList[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(template: Template) {
            itemView.iv_icon.setImageResource(template.rsId)
            itemView.tv_text.text = template.templateName
        }

        init {
            itemView.ll_index_block.setOnClickListener {
                when (adapterPosition) {
                    0 -> ToActivityHelper.getInstance()?.toActivity(context as Activity, ArticalSystemActivity::class.java)
                    1 -> ToActivityHelper.getInstance()?.toActivity(context as Activity, ProjectActivity::class.java)
                    2 -> ToActivityHelper.getInstance()?.toActivity(context as Activity, OfficialCodeActivity::class.java)
                    3 -> ToActivityHelper.getInstance()?.toActivity(context as Activity, SearchActivity::class.java)
                }
            }
        }
    }
}