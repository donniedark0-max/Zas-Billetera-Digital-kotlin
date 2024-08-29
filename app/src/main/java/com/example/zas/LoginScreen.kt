package com.example.zas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zas.ui.theme.ZasColors
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ZasColors.Black)
    { Box(modifier = Modifier
            .fillMaxSize()
        ) {
            IconButton(onClick = { navController.popBackStack() }, modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = ZasColors.Blue,
                    modifier = Modifier
                       .size(24.dp)
                )
            }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Iniciar sesión",
                color = ZasColors.Blue,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo electrónico", color = ZasColors.LightGray) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor =  ZasColors.LightGray,
                    focusedTextColor = ZasColors.LightGray,
                    cursorColor = ZasColors.Blue,
                    focusedBorderColor = ZasColors.Blue,
                    unfocusedBorderColor = ZasColors.LightGray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {password = it },
                label = { Text("Contraseña", color = ZasColors.LightGray) },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = ZasColors.LightGray,
                    cursorColor = ZasColors.Blue,
                    focusedBorderColor = ZasColors.Blue,
                    unfocusedBorderColor = ZasColors.LightGray
                ),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Acción al hacer clic */ },
                colors = ButtonDefaults.buttonColors(containerColor = ZasColors.Blue),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                ) {
                Text("Iniciar sesión",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(15.dp)) // Espacio entre el botón y el texto

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿No tienes una cuenta? ",
                    color = ZasColors.LightGray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = { /* Acción al hacer clic */ }) {
                    Text(
                        text = "Regístrate",
                        color = ZasColors.Green,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }}
    }
}