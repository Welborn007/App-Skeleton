package com.demo.applicationskeleton.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.demo.applicationskeleton.R
import com.demo.applicationskeleton.ViewModelFactory
import com.demo.applicationskeleton.data.DataManager
import com.demo.applicationskeleton.data.network.model.Results
import com.demo.applicationskeleton.data.network.model.WebPackage
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_results.view.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(),ResultsAdapter.Callback {

    @Inject
    lateinit var dataManager: DataManager
    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager
    @Inject
    lateinit var articlesAdapter: ResultsAdapter

    private lateinit var resultsViewModel: ResultsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultsViewModel = ViewModelProviders.of(this,
            ViewModelFactory.getInstance(
                application,
                dataManager)
        ).get(ResultsViewModel::class.java)
        articlesAdapter.setCallback(this)
        init()
    }

    private fun init() {

        setSupportActionBar(toolbar as Toolbar?)

        refresh_layout.setOnRefreshListener {
            resultsViewModel.getArticlesFromNetwork()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<WebPackage?> {
                    override fun onComplete() {
                        refresh_layout.isRefreshing = false
                    }

                    override fun onSubscribe(d: Disposable) {
                        refresh_layout.isRefreshing = true
                        compositeDisposable.add(d)
                    }

                    override fun onNext(t: WebPackage) {
                        articlesAdapter.addItems(t.results as MutableList<Results>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e)
                    }
                })
        }

        article_list.layoutManager = linearLayoutManager
        article_list.adapter = articlesAdapter

        getResults()

    }

    private fun getResults() {
        Observable.concat(
            resultsViewModel.getArticlesFromDatabase(),
            resultsViewModel.getArticlesFromNetwork()
        )
            .observeOn(AndroidSchedulers.mainThread(), true)
            .subscribe(object : Observer<WebPackage?> {
                override fun onComplete() {
                    refresh_layout.isRefreshing = false
                }

                override fun onSubscribe(d: Disposable) {
                    refresh_layout.isRefreshing = true
                    compositeDisposable.add(d)
                }

                override fun onNext(t: WebPackage) {
                    articlesAdapter.addItems(t.results as MutableList<Results>?)
                }

                override fun onError(e: Throwable) {
                    refresh_layout.isRefreshing = false
                    Timber.e(e)
                }
            })
    }

    override fun onArticleClickAccept(stat: Boolean,int: Int) {
        article_list.itemAnimator = SlideInRightAnimator()
        article_list.itemAnimator?.apply {
            addDuration = 1000
            removeDuration = 600
            moveDuration = 1000
            changeDuration = 100
        }

        if(int.equals(0))
        {
            resultsViewModel.getArticlesFromNetwork()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<WebPackage?> {
                    override fun onComplete() {
                        refresh_layout.isRefreshing = false
                    }

                    override fun onSubscribe(d: Disposable) {
                        refresh_layout.isRefreshing = true
                        compositeDisposable.add(d)
                    }

                    override fun onNext(t: WebPackage) {
                        articlesAdapter.addItems(t.results as MutableList<Results>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e)
                    }
                })
        }
    }

    override fun onArticleClickReject(stat: Boolean,int: Int) {
        article_list.itemAnimator = SlideInLeftAnimator()
        article_list.itemAnimator?.apply {
            addDuration = 1000
            removeDuration = 600
            moveDuration = 1000
            changeDuration = 100
        }

        if(int.equals(0))
        {
            resultsViewModel.getArticlesFromNetwork()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<WebPackage?> {
                    override fun onComplete() {
                        refresh_layout.isRefreshing = false
                    }

                    override fun onSubscribe(d: Disposable) {
                        refresh_layout.isRefreshing = true
                        compositeDisposable.add(d)
                    }

                    override fun onNext(t: WebPackage) {
                        articlesAdapter.addItems(t.results as MutableList<Results>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e)
                    }
                })
        }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
