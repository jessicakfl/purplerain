package com.idigue.purplerain

import com.google.gson.annotations.SerializedName

data class user(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String
)
