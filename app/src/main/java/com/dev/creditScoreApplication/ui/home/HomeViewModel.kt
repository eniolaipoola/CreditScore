package com.dev.creditScoreApplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.creditScoreApplication.datasource.Repository
import com.dev.creditScoreApplication.models.CreditScoreEntity
import com.dev.creditScoreApplication.models.Result
import com.dev.creditScoreApplication.utils.exceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository): ViewModel() {

    val creditScoreState = MutableLiveData<Result<CreditScoreEntity>>()

    fun getCreditScoreData() {
        viewModelScope.launch {
            creditScoreState.postValue(Result.Loading(true))
            val result = repository.fetchLocalCreditScoreData()
            if(result != null){
                creditScoreState.postValue(Result.Success(result))
            }
        }
    }

    fun fetchRemoteCreditScoreData(){
        viewModelScope.launch(exceptionHandler(creditScoreState)) {
            creditScoreState.postValue(Result.Loading(true))
            repository.fetchRemoteCreditScoreData()
            getCreditScoreData()
        }
    }

}