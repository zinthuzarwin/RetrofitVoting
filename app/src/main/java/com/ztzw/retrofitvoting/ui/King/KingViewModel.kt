package com.ztzw.retrofitvoting.ui.King

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ztzw.retrofitvoting.model.King
import com.ztzw.retrofitvoting.model.KingItem

class KingViewModel : ViewModel() {

    var kingList: MutableLiveData<List<King>> = MutableLiveData()
    var kingApi =
}