package com.example.tugas5_esjumbo.ui

import android.icu.text.NumberFormat
import androidx.lifecycle.ViewModel
import com.example.tugas5_esjumbo.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private const val HARGA_PER_CUP = 3000


private val _stateUI = MutableStateFlow(ContactUiState())
val stateUI: StateFlow<ContactUiState>  = _stateUI.asStateFlow()

fun setContact(list: MutableList<String>){
    _stateUI.update { stateSaatIni -> stateSaatIni.copy(
        nama = list [0],
        alamat = list[1],
        tlp = list[2]
    )
    }

class OrderViewModel : ViewModel () {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlhEsJumbo:Int){
        _stateUI.update {stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlhEsJumbo,
                harga = hitungHarga(jumlah = jmlhEsJumbo)) }

    }
    fun setRasa(rasaPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
        }
    }
    fun resetOrder(){
        _stateUI.value = OrderUIState()
    }
    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,

    ): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP
        return NumberFormat.getNumberInstance().format(kalkulasiHarga)

    }
    }
