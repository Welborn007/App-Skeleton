package com.demo.applicationskeleton.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.demo.applicationskeleton.R
import com.demo.applicationskeleton.data.network.model.DomesticPackage
import com.vicky7230.flux.utils.GlideApp
import kotlinx.android.synthetic.main.webpackage_list_tem.view.*

class WebPackageAdapter(private val domesticPackageData: MutableList<DomesticPackage>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Callback {
        fun onArticleClick(url: String)
    }

    private var callback: Callback? = null

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun addItems(articles: MutableList<DomesticPackage>?) {
        this.domesticPackageData?.clear()
        articles?.let { this.domesticPackageData?.addAll(it) }
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): DomesticPackage? {
        return if (position != RecyclerView.NO_POSITION) {
            domesticPackageData?.get(position)
        } else
            null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val articleViewHolder = ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.webpackage_list_tem, parent, false))
        articleViewHolder.itemView.setOnClickListener({
//            val article: DomesticPackage? = getItem(articleViewHolder.adapterPosition)
//            if (article != null) {
//                callback?.onArticleClick(article.url ?: "")
//            }
        })
        return articleViewHolder
    }

    override fun getItemCount(): Int {
        return domesticPackageData?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).onBind(domesticPackageData?.get(position))
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(article: DomesticPackage?) {
            GlideApp
                    .with(itemView.context)
                    .load(article?.image)
                    .transition(withCrossFade())
                    .fitCenter()
                    .into(itemView.image)

            itemView.title.text = article?.name
        }
    }
}