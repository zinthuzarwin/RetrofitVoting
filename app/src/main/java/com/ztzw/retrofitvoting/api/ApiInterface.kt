package com.ztzw.retrofitvoting.api

import com.ztzw.retrofitvoting.model.KingItem
import com.ztzw.retrofitvoting.model.QueenItem
import com.ztzw.retrofitvoting.model.VoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @POST("kingvote")
    fun voteking(
        @Query("code") code: String,
        @Query("king_id") king_id: String
    ) : Call<VoteResponse>


    @POST("queenvote")
    fun votequeen(
        @Query("code") code: String,
        @Query("queen_id") queen_id: String
    ) : Call<VoteResponse>

    @GET(value = "king")
    fun getKing(): Call<List<KingItem>>

    @GET(value = "queen")
    fun getQueen(): Call<List<QueenItem>>

}