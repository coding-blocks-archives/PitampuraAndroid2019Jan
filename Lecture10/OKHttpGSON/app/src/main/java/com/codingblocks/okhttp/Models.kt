package com.codingblocks.okhttp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response(
    val abilities: ArrayList<Ability>,
    @SerializedName("base_experience") val baseExperience: Int,
    val forms: ArrayList<Form>,
    @SerializedName("game_indices") val gameIndices: ArrayList<GameIndex>,
    val height: Double,
    val id: Int,
    val name: String,
    val order: Int,
    val species: Form,
    val sprites: Sprites,
    val weight: Double
)

class Ability(
    val ability: Form,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
)

class Form(
    val name: String,
    val url: String
)

class GameIndex(
    @SerializedName("game_index") val gameIndex: Int,
    val version: Form
)

class Sprites(
    @SerializedName("back_default") val backDefault: String,
    @SerializedName("front_default") val frontDefault: String
)

