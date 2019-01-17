package com.demo.applicationskeleton.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.demo.applicationskeleton.data.network.model.Results
import com.vicky7230.flux.utils.GlideApp
import kotlinx.android.synthetic.main.list_item_results.view.*


class ResultsAdapter(private val results: MutableList<Results>?) :
    androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

    interface Callback {
        fun onArticleClickAccept(stat: Boolean,int: Int)
        fun onArticleClickReject(stat: Boolean,int: Int)
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val articleViewHolder =
            ArticleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    com.demo.applicationskeleton.R.layout.list_item_results,
                    parent,
                    false
                )
            )
        articleViewHolder.itemView.setOnClickListener({

        })

        articleViewHolder.itemView.accept.setOnClickListener({
            results?.removeAt(articleViewHolder.adapterPosition)
            notifyItemRemoved(articleViewHolder.adapterPosition)
            callback?.onArticleClickAccept(true, results!!.size)
        })

        articleViewHolder.itemView.reject.setOnClickListener({
            results?.removeAt(articleViewHolder.adapterPosition)
            notifyItemRemoved(articleViewHolder.adapterPosition)
            callback?.onArticleClickReject(true,results!!.size)
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
            var picture = article?.picture

            val requestOption = RequestOptions()
                .placeholder(com.demo.applicationskeleton.R.drawable.ic_placeholder).centerCrop()

            GlideApp
                .with(itemView.context)
                .load(picture?.large)
                .fitCenter()
                .apply(requestOption)
                .into(itemView.image)

            var name = article?.name

            val FirstName = name?.first?.substring(0, 1)?.toUpperCase() + name?.first?.substring(1)
            val LastName = name?.last?.substring(0, 1)?.toUpperCase() + name?.last?.substring(1)

            itemView.title.text = FirstName + " " + LastName

            itemView.description.text = article?.dob?.age + " yrs, Maharashtrian, Marathi"
            itemView.location.text = article?.location?.city + " ," + article?.location?.state +
                    " , Bachelors of Engineering - IT"
            itemView.designation.text = "Mobile App Developer / Freelancer"
        }
    }
}