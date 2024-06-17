package fr.hamtec.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,       //++ Représente un ID de chaîne de caractères stockée dans une ressource string.
    @DrawableRes val imageResourceId: Int       //++ Représente un ID de l'image d'affirmation stockée dans une ressource drawable.
)
