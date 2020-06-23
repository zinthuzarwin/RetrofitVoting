package com.ztzw.retrofitvoting.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserItem(
    val `class`: String,
    val id: String,
    val img_url: String,
    val name: String,
    val vote_count: Int,
    val vote_time_status: Int
): Parcelable