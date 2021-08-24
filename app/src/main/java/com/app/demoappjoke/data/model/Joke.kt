package com.app.demoappjoke.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "jokes")

data class Joke  (
    @PrimaryKey(autoGenerate = true)
    val dataId:Int? = null,
    @SerializedName("id") var Id: String?,
    @SerializedName("joke") var Joke: String?,
    @SerializedName("status") var Status: String?
): Serializable