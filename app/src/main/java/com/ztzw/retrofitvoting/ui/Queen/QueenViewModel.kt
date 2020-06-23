package com.ztzw.retrofitvoting.ui.Queen

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ztzw.retrofitvoting.api.VotingApi
import com.ztzw.retrofitvoting.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenViewModel : ViewModel() {

    val queenList: MutableLiveData<User> = MutableLiveData()

    var queenApi = VotingApi()

    fun getQueenModel():MutableLiveData<User> = queenList

    fun loadQueenModel() {

        var apiCallQueenList = queenApi.getQueen()

        apiCallQueenList.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("Checked...",t.toString())
            }

            override fun onResponse(call: Call<User>, response: Response<User>)
            {
                var queenLists = response.body()


                Log.d("Response>>>>", queenList.toString())

                queenList.value = queenLists
            }

        })
    }

}