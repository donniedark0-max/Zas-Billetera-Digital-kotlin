package com.example.zas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.zas.ui.theme.ZasColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(currentRoute: String, // Agrega currentRoute como parámetro
                   navController: NavHostController,
                   content: @Composable (PaddingValues) -> Unit) {
    var showTopAndBottomBars by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            if (showTopAndBottomBars) {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment= Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { /* Acción al hacer clic en el icono de menú */ }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menú")
                            }
                            Text(
                                text = "Zas",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            IconButton(onClick = { /* Acción al hacer clic en el icono de campana */ }) {
                                Icon(Icons.Filled.Notifications, contentDescription = "Notificaciones")
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = ZasColors.Black,
                        titleContentColor = Color.White,
                        actionIconContentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        bottomBar = {
            if (showTopAndBottomBars) {
                NavigationBar(
                    containerColor = ZasColors.Black,
                    contentColor = Color.Black
                ) {
                    val items = listOf(
                        Screen.Home,
                        Screen.CreditCard,
                        Screen.Send,
                        Screen.User
                    )
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.title) },
                            label = { Text(screen.title, color = Color.White) },
                            selected = currentRoute == screen.route,
                            onClick = {
                                // Acción al hacer clic en el elemento
                                navController.navigate(screen.route)
                            },
                            colors = colors(
                                selectedIconColor = ZasColors.Blue,
                                unselectedIconColor = ZasColors.LightGray,
                                indicatorColor = Color.Transparent // Sin indicador
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Inicio", Icons.Filled.Home)
    object CreditCard : Screen("credit_card", "Tarjeta", Icons.Filled.CreditCard)
    object Send : Screen("send", "Enviar", Icons.Filled.Send)
    object User : Screen("user", "Usuario", Icons.Filled.Person)
}