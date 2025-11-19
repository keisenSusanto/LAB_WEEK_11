package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsStore: SettingsStore) : ViewModel() {

    // LiveData untuk update UI ketika text berubah
    private val _textLiveData = MutableLiveData<String>()
    val textLiveData: LiveData<String> = _textLiveData

    init {
        // Ambil data dari DataStore secara async (coroutine)
        viewModelScope.launch {
            settingsStore.text.collect {
                _textLiveData.value = it
            }
        }
    }

    // Simpan text ke DataStore
    fun saveText(text: String) {
        viewModelScope.launch {
            settingsStore.saveText(text)
        }
    }
}
