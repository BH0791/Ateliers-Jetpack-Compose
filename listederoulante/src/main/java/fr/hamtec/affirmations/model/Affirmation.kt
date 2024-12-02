package fr.hamtec.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Une classe de données est un type qui ne contient que des propriétés.
 * Elle peut fournir des méthodes utilitaires qui fonctionnent avec ces propriétés.
 */
data class Affirmation(
    /**
     * Indique qu'un paramètre entier, un champ ou une valeur de retour de méthode doit être une
     * référence de ressource de type chaîne de caractères (par exemple, android.R.string.ok).
     */
    @StringRes val stringResourceId: Int,       //++ Représente un ID de chaîne de caractères stockée dans une ressource string.
    /**
     * Indique qu'un paramètre entier, un champ ou une valeur de retour de méthode est censé être
     * une référence de ressource dessinable (par exemple, android.R.attr.alertDialogIcon).
     */
    @DrawableRes val imageResourceId: Int       //++ Représente un ID de l'image d'affirmation stockée dans une ressource drawable.
)
