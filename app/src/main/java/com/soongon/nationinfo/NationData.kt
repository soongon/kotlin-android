package com.soongon.nationinfo

data class NationDetail(val name: String, val capital: String, val location: String, val volume: String, val weather: String, val language: String)

data class NationDetails(val data: ArrayList<NationDetail>)