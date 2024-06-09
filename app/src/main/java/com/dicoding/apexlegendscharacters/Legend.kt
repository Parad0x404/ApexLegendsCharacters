package com.dicoding.apexlegendscharacters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Legend(
    val name: String,
    val title: String,
    val description: String,
    val photo: String,
    val realName: String,
    val age: String,
    val homeWorld: String
) : Parcelable
