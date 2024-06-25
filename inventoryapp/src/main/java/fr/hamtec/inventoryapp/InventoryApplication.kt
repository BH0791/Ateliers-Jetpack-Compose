package fr.hamtec.inventoryapp


import android.app.Application
import fr.hamtec.inventoryapp.data.AppContainer
import fr.hamtec.inventoryapp.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}