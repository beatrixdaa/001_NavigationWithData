package com.example.tugas5_esjumbo.data

data class OrderUIState(
    val jumlah: Int = 0,
    val rasa: String = "",
    val harga: String = "",
    var nama:String="",
    var alamat:String="",
    var tlp:String=""
)
