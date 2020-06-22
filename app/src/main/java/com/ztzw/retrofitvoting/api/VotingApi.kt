package com.ztzw.retrofitvoting.api

import com.ztzw.retrofitvoting.model.KingItem
import com.ztzw.retrofitvoting.model.QueenItem
import com.ztzw.retrofitvoting.model.VoteResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VotingApi {

    companion object {
        const val BASE_URL = " https://ucsmonywaonlinevote.000webhostapp.com/api/"
    }

    private val apiInterface: ApiInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getKing() : Call<List<KingItem>> = apiInterface.getKing()

    fun getQueen() : Call<List<QueenItem>> = apiInterface.getQueen()

    fun voteKing(code: String, king_id: String) : Call<VoteResponse> = apiInterface.voteking(code, king_id)

    fun voteQueen(code: String, queen_id: String) : Call<VoteResponse> = apiInterface.voteking(code, queen_id)

}