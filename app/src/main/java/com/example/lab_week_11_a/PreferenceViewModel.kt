package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PreferenceViewModel(private val preferenceWrapper: PreferenceWrapper)
    : ViewModel() {

    // Menyimpan text ke SharedPreferences
    fun saveText(text: String) {
        preferenceWrapper.saveText(text)
    }

    // Mengambil text dari SharedPreferences
    fun getText(): LiveData<String> {
        return preferenceWrapper.getText()
    }
}
