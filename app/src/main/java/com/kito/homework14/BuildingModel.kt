package com.kito.homework14

import com.squareup.moshi.Json

data class BuildingModel (
    val descriptionKA: String?,
    val titleKA: String?,
    val cover: Int?,
    @Json(name = "publish_date")
    val publishDate: Int?
)
