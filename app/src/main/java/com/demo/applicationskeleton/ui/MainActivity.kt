package com.demo.applicationskeleton.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.demo.applicationskeleton.R
import com.demo.applicationskeleton.ViewModelFactory
import com.demo.applicationskeleton.data.DataManager
import com.demo.applicationskeleton.data.network.model.DomesticPackage
import com.demo.applicationskeleton.data.network.model.WebPackage
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(),WebPackageAdapter.Callback {

    @Inject
    lateinit var dataManager: DataManager
    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var articlesAdapter: WebPackageAdapter

    private lateinit var domesticPackageViewModel: DomesticPackageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        domesticPackageViewModel = ViewModelProviders.of(this,
            ViewModelFactory.getInstance(
                application,
                dataManager)
        ).get(DomesticPackageViewModel::class.java)
        articlesAdapter.setCallback(this)
        init()
    }

    private fun init() {

        setSupportActionBar(toolbar as Toolbar?)

        refresh_layout.setOnRefreshListener {
            domesticPackageViewModel.getArticlesFromNetwork()
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
                        articlesAdapter.addItems(t.DOMESTIC_PACKAGE as MutableList<DomesticPackage>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e)
                    }
                })
        }

        article_list.layoutManager = linearLayoutManager
        article_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        article_list.adapter = articlesAdapter

        getArticles()

    }

    private fun getArticles() {
        Observable.concat(
            domesticPackageViewModel.getArticlesFromDatabase(),
            domesticPackageViewModel.getArticlesFromNetwork()
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
                    articlesAdapter.addItems(t.DOMESTIC_PACKAGE as MutableList<DomesticPackage>?)
                }

                override fun onError(e: Throwable) {
                    refresh_layout.isRefreshing = false
                    Timber.e(e)
                }
            })
    }

    override fun onArticleClick(url: String) {

    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
