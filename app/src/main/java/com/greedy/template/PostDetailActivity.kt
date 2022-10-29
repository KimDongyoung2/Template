package com.greedy.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy.template.API.Item
import com.greedy.template.API.Response
import com.greedy.template.databinding.ActivityPostDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostDetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPostDetailBinding.inflate(layoutInflater) }
    private lateinit var item: Item
    private lateinit var itemList: MutableList<Item?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val postId = intent.getStringExtra("postId")
        val facltNm = intent.getStringExtra("facltNm")
        val intro = intent.getStringExtra("intro")
         binding.title.text = postId
        binding.content.text=facltNm
        binding.commentCount.text=intro

//          binding.content.text = item.lineIntro

          binding.layout.visibility = View.VISIBLE
           binding.progressBar.visibility = View.GONE
//       loadData(postId)

    }

//    private fun loadData(postId: Int) {
//
//        CoroutineScope(Dispatchers.Main).launch {
//
//            withContext(Dispatchers.IO) {
//                val postResponse = PostsService.getPostsService().post(postId)
//                if (postResponse.isSuccessful) {
//                    item = postResponse.body()!!
//                } else {
//                    Log.d("Error", "${postResponse.message()}")
//                }
//            }
////            itemList =response.body.items.item.toMutableList()

//
//        }


//    }
}