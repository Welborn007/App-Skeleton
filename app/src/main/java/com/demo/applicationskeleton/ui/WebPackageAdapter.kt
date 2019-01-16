package com.demo.applicationskeleton.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.demo.applicationskeleton.R
import com.demo.applicationskeleton.data.network.model.Results
import com.vicky7230.flux.utils.GlideApp
import kotlinx.android.synthetic.main.webpackage_list_tem.view.*

class WebPackageAdapter(private val results: MutableList<Results>?) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    interface Callback {
        fun onArticleClick(url: String)
    }

    private var callback: Callback? = null

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun addItems(articles: MutableList<Results>?) {
        this.results?.clear()
        articles?.let { this.results?.addAll(it) }
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Results? {
        return if (position != androidx.recyclerview.widget.RecyclerView.NO_POSITION) {
            results?.get(position)
        } else
            null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
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
        return results?.size ?: 0
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).onBind(results?.get(position))
    }

    class ArticleViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun onBind(article: Results?) {
//            GlideApp
//                    .with(itemView.context)
//                    .load(article?.image)
//                    .transition(withCrossFade())
//                    .fitCenter()
//                    .into(itemView.image)

            var name = article?.name

            itemView.title.text = name?.first + " " + name?.last
        }
    }
}