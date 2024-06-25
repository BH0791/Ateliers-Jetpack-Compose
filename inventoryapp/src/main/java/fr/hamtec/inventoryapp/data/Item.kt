package fr.hamtec.inventoryapp.data


/**
 * La classe de données d'entité représente une seule ligne dans la base de données.
 */
class Item(
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)