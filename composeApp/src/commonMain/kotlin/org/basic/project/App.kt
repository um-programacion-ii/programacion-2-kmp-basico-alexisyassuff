package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.basic.project.bottomBar.BottomBarScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = MainScreen()
        )
    }
}


class MainScreen: Screen {

    @Composable
    override fun Content(){
        val navController: Navigator = LocalNavigator.currentOrThrow

        var usuarioInput: String by remember { mutableStateOf("") }
        var claveInput: String by remember { mutableStateOf("")}
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TextField(
                value = usuarioInput,
                onValueChange = { usuarioInput = it },
                label = { Text("Usuario") }
            )

            Spacer(modifier = Modifier.height(32.dp))

            AnimatedVisibility(usuarioInput.isNotEmpty()){
                Text(
                    text = "Texto animado: $usuarioInput" ,
                    fontSize = 36.sp
                )
            }
            
            Spacer(modifier = Modifier.height(45.dp))

            TextField(
                value = claveInput,
                onValueChange = { claveInput = it },
                label = { Text("Clave") }
            )

            Spacer(modifier = Modifier.height(45.dp))

            AnimatedVisibility(claveInput.isNotEmpty()){
                Text(
                    text = "Clave ingresada: $claveInput",
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            
            Button(
                onClick = { navController.push(ScreenTwo()) }
            ){
                Text("Ir a Segunda")
            }
            
            Spacer(modifier = Modifier.height(25.dp))
            
            Button(
                onClick = { navController.push(ScreenThree()) }
            ){
                Text("Ir a Tercera")
            }
            
            Spacer(modifier = Modifier.height(25.dp))
            
            Button(
                onClick = { navController.push(BottomBarScreen()) }
            ){
                Text("Tab Navigator")
            }
        }
    }
}

class ScreenTwo: Screen {

    @Composable
    override fun Content() {
        val nav: Navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pantalla Dos",
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { nav.pop() }
            ) {
                Text("Regresar")
            }
        }
    }
}

class ScreenThree: Screen{

    @Composable
    override fun Content(){
        val navController: Navigator = LocalNavigator.currentOrThrow
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pantalla Tres",
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(35.dp))
            Button(
                onClick = { navController.pop() }
            ){
                Text("Atrás")
            }
        }
    }
}

