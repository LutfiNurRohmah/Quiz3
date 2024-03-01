package com.lutfi.quiz3.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lutfi.quiz3.data.response.ApiResponseItem
import com.lutfi.quiz3.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val _listItem = MutableLiveData<List<ApiResponseItem?>>()
    val listItem: LiveData<List<ApiResponseItem?>> = _listItem

    init {
        getItem()
    }
    private fun getItem() {
        val client = ApiConfig.getApiService().getItem()
        client.enqueue(object: Callback<List<ApiResponseItem>> {
            override fun onResponse(
                call: Call<List<ApiResponseItem>>,
                response: Response<List<ApiResponseItem>>
            ) {
                if (response.isSuccessful) {
                    _listItem.value = response.body()
                } else {
                    Log.e(TAG, "onFailureee: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ApiResponseItem>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}