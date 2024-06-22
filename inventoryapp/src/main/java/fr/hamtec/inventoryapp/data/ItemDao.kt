package fr.hamtec.inventoryapp.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface ItemDao {

    /*-- ignore le nouvel élément si sa clé primaire figure déjà dans la base de données. */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    /*! Il n'existe aucune annotation spécifiquement adaptée aux fonctionnalitées restante. Vous devez donc utiliser l'annotation @Query et fournir des requêtes SQLite. */

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>        //-- Il est recommandé d'utiliser Flow dans la couche de persistance

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}