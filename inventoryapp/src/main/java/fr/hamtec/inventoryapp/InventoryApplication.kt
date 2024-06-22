package fr.hamtec.inventoryapp


import android.app.Application
import fr.hamtec.inventoryapp.data.AppContainer
import fr.hamtec.inventoryapp.data.AppDataContainer
import fr.hamtec.inventoryapp.data.ItemRoomDatabase

class InventoryApplication : Application() {

    /**
     * instance d'AppContainer utilisée par le reste des classes pour obtenir des dépendances
     */
    lateinit var container: AppContainer

    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}