package com.wulantorodev.movie.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.DividerItemDecoration
import com.wulantorodev.movie.*
import com.wulantorodev.movie.databinding.ActivityHomeBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity(), HomeViewModelCallback {

    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.activity_home)
            apply { viewModel = this@HomeActivity.viewModel }
                .also { viewModel.discoverMovie() }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }

    override fun onSuccess(results: List<Result>) {
        binding.rvHome.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        binding.rvHome.adapter = HomeAdapter(results)
    }

    override fun onError(error: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
    }

//    override fun onShowLoading() {
//        pb_home.visibility = View.VISIBLE
//    }
//
//    override fun onHideLoading() {
//
//        pb_home.visibility = View.GONE
//        rv_home.visibility = View.VISIBLE
//    }
//
//    override fun onResponse(results: List<Result>) {
//        rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
//        rv_home.adapter = HomeAdapter(results)
//    }
//
//    override fun onFailure(error: Throwable) {
//        Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
//    }
}

//class HomeActivity: AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        val progressBar = findViewById<ProgressBar>(R.id.pb_home)
//
//        val dataSource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
//
//        dataSource.discoverMovie().enqueue(object : Callback<HomeResponse> {
//            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
//                progressBar.visibility = View.GONE
//
//                val results = response.body()?.results
//                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
//                itemAdapter.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
//                itemAdapter.adapter = HomeAdapter(results ?: emptyList() )
//
//            }
//
//            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
//                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")
//            }
//        })
//    }
//}