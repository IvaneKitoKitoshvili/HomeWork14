package com.kito.homework14

import com.google.gson.annotations.SerializedName


data class Content(
    val content: List<BuildingModel>,
) {
    data class BuildingModel(
        val cover: String,
        val descriptionKA: String,
        @SerializedName("publish_date")
        val publishDate: String?,
        val titleKA: String
    )
}
