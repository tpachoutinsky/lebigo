package com.example.lebigo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataForBindingViewModel: ViewModel() {
    private val _dataForBinding = MutableLiveData<DataForBinding>()
    val dataForBinding: LiveData<DataForBinding> = _dataForBinding

    init{
        _dataForBinding.value = DataForBinding(0.0, 0.0)
    }
    fun updateDataForBinding(newData: DataForBinding){
        _dataForBinding.value = newData
        _dataForBinding.value?.let { oldData ->
            val data = oldData.copy(resultatHaut = newData.resultatHaut?:oldData.resultatHaut,
                                    resultatBas = newData.resultatBas?:oldData.resultatBas)
            _dataForBinding.value = data
        }
    }
}
