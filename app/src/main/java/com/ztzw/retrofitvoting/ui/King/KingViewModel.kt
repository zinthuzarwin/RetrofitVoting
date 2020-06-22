package com.ztzw.retrofitvoting.ui.King

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ztzw.retrofitvoting.api.VotingApi
import com.ztzw.retrofitvoting.model.KingItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingViewModel : ViewModel() {

    val kingList: MutableLiveData<List<KingItem>> = MutableLiveData()

    var kingApi = VotingApi()

    fun loadKingModel() {

        var apiCallKingList = kingApi.getKing()

        apiCallKingList.enqueue(object : Callback<List<KingItem>>{
            override fun onFailure(call: Call<List<KingItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<KingItem>>, response: Response<List<KingItem>>)
            {
                var kingList = response.body()
                Log.d("Response>>>>", kingList.toString())

                if(kingList != null){
                    loadKingModel()
                }
            }

        })
    }

}