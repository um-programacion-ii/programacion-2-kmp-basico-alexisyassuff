package org.basic.project.bottomBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            tab = HomeTabScreen,
            tabDisposable = { tabNav ->
                TabDisposable(
                    navigator = tabNav,
                    tabs = listOf(
                        HomeTabScreen,
                        UserTabScreen,
                        MenuTabScreen
                    )
                )
            }
        ) { tabNavState ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = tabNavState.current.options.title
                            )
                        }
                    )
                },
                bottomBar = {
                    NavigationBar {
                        val currentTabNav: TabNavigator = LocalTabNavigator.current

                        NavigationBarItem(
                            selected = currentTabNav.current.key == HomeTabScreen.key,
                            label = {
                                Text(
                                    text = HomeTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = HomeTabScreen.options.icon!!,
                                    contentDescription = "Home"
                                )
                            },
                            onClick = {
                                currentTabNav.current = HomeTabScreen
                            }
                        )
                        NavigationBarItem(
                            selected = currentTabNav.current.key == UserTabScreen.key,
                            label = {
                                Text(
                                    text = UserTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = UserTabScreen.options.icon!!,
                                    contentDescription = "User"
                                )
                            },
                            onClick = {
                                currentTabNav.current = UserTabScreen
                            }
                        )
                        NavigationBarItem(
                            selected = currentTabNav.current.key == MenuTabScreen.key,
                            label = {
                                Text(
                                    text = MenuTabScreen.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = MenuTabScreen.options.icon!!,
                                    contentDescription = "Menu"
                                )
                            },
                            onClick = {
                                currentTabNav.current = MenuTabScreen
                            }
                        )
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }
}