package com.android1500.interviewapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostData(val userId : Int,val id : Int, val title : String , val body : String):
    Parcelable