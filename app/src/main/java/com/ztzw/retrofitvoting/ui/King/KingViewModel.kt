package com.ztzw.retrofitvoting.ui.King

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ztzw.retrofitvoting.api.VotingApi
import com.ztzw.retrofitvoting.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingViewModel : ViewModel() {

    val kingList: MutableLiveData<User> = MutableLiveData()

    var kingApi = VotingApi()

    fun getKingModel():MutableLiveData<User> = kingList

    fun loadKingModel() {

        var apiCallKingList = kingApi.getKing()

        apiCallKingList.enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<User>, response: Response<User>)
            {
                var kingLists = response.body()


                Log.d("Response>>>>", kingList.toString())

               kingList.value = kingLists
            }

        })
    }

}