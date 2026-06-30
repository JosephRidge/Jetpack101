package com.emobilis.jetpack101.data.model

// this is a data model => a blueprint to create an actual object0
data class Route<T:Any>(
    val name:String,
    val route:T,
    val icon:Int
)
