package br.com.fiap.imc

fun Double.toFixed(digits: Int) = String.format("%.${digits}f", this)