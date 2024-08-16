package fr.hamtec.inventoryapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * La classe de données d'entité représente une seule ligne dans la base de données.
 */
@Entity(tableName = "items")        // *  Par défaut (sans argument pour @Entity), le nom de la table est identique à celui de la classe
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)
//++ Félicitations !