package com.ztzw.retrofitvoting.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.api.ApiInterface
import com.ztzw.retrofitvoting.model.UserItem
import com.ztzw.retrofitvoting.model.VoteResponse
import kotlinx.android.synthetic.main.fragment_vote.*
import kotlinx.android.synthetic.main.king_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VoteFragment : Fragment() {

    val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"

    private lateinit var apiCall: Call<VoteResponse>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messageArgs = arguments?.let {
                VoteFragmentArgs.fromBundle(it)
        }

        var user = messageArgs?.user


        Picasso.get()
            .load(user?.img_url)
            .placeholder(R.drawable.loading)
            .into(ImgProfile)

        txtName.text = user?.name
        txtClassromm.text = user?.`class`
        txtVoteCount.text = user?.vote_count.toString()

        btnVote.setOnClickListener {

            var code = txtCode.text.toString()

            if (user != null) {
                vote(code, user)
            }

        }

    }


    fun vote(code: String, user: UserItem) {

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(ApiInterface::class.java)

        if (user != null) {
            if(user.id.startsWith("K")) {

                apiCall = retrofitService.voteking(code,user.id)
            }else {
                apiCall = retrofitService.votequeen(code, user.id)
            }
            apiCall.enqueue(object: Callback<VoteResponse>{
                override fun onFailure(call: Call<VoteResponse>, t: Throwable) {
                    Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<VoteResponse>,
                    response: Response<VoteResponse>
                ) {
                    Toast.makeText(context,response.body().toString(), Toast.LENGTH_LONG).show()
                }

            })
        }



    }



}