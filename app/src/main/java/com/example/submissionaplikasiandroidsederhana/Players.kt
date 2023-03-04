package com.example.submissionaplikasiandroidsederhana
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players(val name: String,
                   val description: String,
                   val position :String,
                   val birth :String,
                   val photo: Int) : Parcelable
