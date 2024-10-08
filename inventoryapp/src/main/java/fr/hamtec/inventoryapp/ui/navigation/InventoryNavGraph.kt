package fr.hamtec.inventory.ui.navigation
/*      ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ++ Ce fichier est le graphique de navigation pour toute l'application.  ++
        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fr.hamtec.inventory.ui.item.ItemDetailsDestination
import fr.hamtec.inventory.ui.item.ItemDetailsScreen
import fr.hamtec.inventory.ui.item.ItemEditDestination
import fr.hamtec.inventory.ui.item.ItemEditScreen
import fr.hamtec.inventory.ui.item.ItemEntryDestination
import fr.hamtec.inventory.ui.item.ItemEntryScreen
import fr.hamtec.inventoryapp.ui.home.HomeDestination
import fr.hamtec.inventoryapp.ui.home.HomeScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
