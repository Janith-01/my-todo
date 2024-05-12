package com.example.mytodo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mytodo.ui.task.HomeDestination
import com.example.mytodo.ui.task.HomeScreen
import com.example.mytodo.ui.task.NewTaskDestination
import com.example.mytodo.ui.task.NewTaskScreen
import com.example.mytodo.ui.task.TaskInformationDestination
import com.example.mytodo.ui.task.TaskInformationScreen


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
                navigateToNewTask = { navController.navigate(NewTaskDestination.route) },
                navigateToTaskInformation = {
                    navController.navigate("${TaskInformationDestination.route}/${it}")
                }
            )
        }
        composable(route = NewTaskDestination.route) {
            NewTaskScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = TaskInformationDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskInformationDestination.taskIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskInformationScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}
