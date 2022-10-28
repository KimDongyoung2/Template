package com.greedy.template

import com.greedy.template.API.Item
import com.greedy.template.API.ResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {

    /* Post 전체 목록 조회 */
    @GET("B551011/GoCamping/basedList?serviceKey=HeF%2Fbl5S7APRtDPyFXBZW1zx4ByiA8JZqMnddbu42Me3grrFY%2FSxRHm0okJwTz%2BD%2FsaWL9G4clNbQvzoagGgXQ%3D%3D&numOfRows=10&pageNo=1&MobileOS=AND&MobileApp=Template&_type=json")
    suspend fun posts() : Response<ResponseData>
//    @Query("pageNo") skip: Int = 0, @Query("numOfRows") limit: Int = 20
    /* Post 1개 상세 조회 */
//   @GET("items/{contentId}")
//    suspend fun post(@Path("contentId") id: Int) : Response<Item>
//

}