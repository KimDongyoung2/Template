package com.greedy.template

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostsService {

    fun getPostsService() : PostsApi {

        return Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsApi::class.java)

    }
}