package com.emobilis.jetpack101.data.model

data class Route<T:Any>(
    val name:String,
    val route:T,
    val icon:Int
)
