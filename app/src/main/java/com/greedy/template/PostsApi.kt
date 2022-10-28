package com.greedy.template

import com.greedy.template.API.Body
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostsApi {

    /* Post 전체 목록 조회 */
    @GET("B551011/GoCamping/basedList?serviceKey=HeF%2Fbl5S7APRtDPyFXBZW1zx4ByiA8JZqMnddbu42Me3grrFY%2FSxRHm0okJwTz%2BD%2FsaWL9G4clNbQvzoagGgXQ%3D%3D&numOfRows=10&pageNo=1&MobileOS=AND&MobileApp=template&_type=json")
    suspend fun posts(@Query("pageNo") skip: Int = 0, @Query("numOfRows") limit: Int = 20) : Response<Body>

//    /* Post 1개 상세 조회 */
//    @GET("items/{commentId}")
//    suspend fun post(@Path("id") id: Int) : Response<Body>


}