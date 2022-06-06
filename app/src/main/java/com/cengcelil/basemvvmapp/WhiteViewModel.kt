package com.cengcelil.basemvvmapp

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class WhiteViewModel @Inject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {
    // TODO: Implement the ViewModel
}