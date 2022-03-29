package com.example.stockpredicter.activities.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.stockpredicter.adapters.NewsAdapter
import com.example.stockpredicter.api.NewsApi


import com.example.stockpredicter.databinding.FragmentNewsBinding
import com.example.stockpredicter.models.Articles
import com.example.stockpredicter.models.NewsData
import com.example.stockpredicter.utils.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        setupNewsRV()

        return binding.root
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupNewsRV(){

        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(NewsApi::class.java)
        val call = service.getNewsData()

        call.enqueue(object : Callback<NewsData> {
            override fun onResponse(
                call: Call<NewsData>,
                response: Response<NewsData>
            ) {
                if (response.code() == 200) {
                    val list = response.body()?.articles
                    list?.get(0)?.let { Log.e("DATA", it.toString()) }


                    binding.rvNews.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                    val newsAdapter = activity?.let { NewsAdapter(it, list!!) }
                    binding.rvNews.adapter = newsAdapter

                }
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.e("lmao", "${t.message}")

            }

        })





    }
};