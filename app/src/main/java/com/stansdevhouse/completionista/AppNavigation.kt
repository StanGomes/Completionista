package com.stansdevhouse.completionista

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.stansdevhouse.core.Argument
import com.stansdevhouse.explore.ExploreScreen
import com.stansdevhouse.game_details.GameDetails

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
internal fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Explore.route
    ) {
        addExploreScreen(
            openShowDetails = { gameId ->
                navController.navigate(Screen.GameDetails.createRoute(gameId))
            })
        addGameDetailsScreen()
    }
}

@ExperimentalPagerApi
@ExperimentalUnitApi
@ExperimentalMaterialApi
private fun NavGraphBuilder.addExploreScreen(openShowDetails: (Int) -> Unit) {
    composable(Screen.Explore.route) {
        ExploreScreen(
            exploreViewModel = hiltViewModel(),
            openShowDetails = { gameId ->
                openShowDetails(gameId)
            })
    }
}

private fun NavGraphBuilder.addGameDetailsScreen() {
    composable(
        route = Screen.GameDetails.route,
        arguments = listOf(navArgument(Argument.ARG_GAME_ID) {
            type = NavType.IntType
        })
    ) {
        GameDetails(gameDetailViewModel = hiltViewModel())
    }
}

private sealed class Screen(val route: String) {
    object Explore : Screen("explore")
    object GameDetails : Screen("game/{${Argument.ARG_GAME_ID}}") {
        fun createRoute(gameId: Int): String = "game/$gameId"
    }
}