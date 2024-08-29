package com.example.zas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zas.ui.theme.ZasColors
import com.example.zas.ui.theme.ZasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
            ZasTheme {
                InitScreen()

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun InitScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ZasColors.Black,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Zas",
                color = ZasColors.Blue,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Tu billetera digital para un manejo fácil y seguro de tu dinero",
                color = ZasColors.LightGray,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(6.dp, top = 26.dp),
                textAlign = TextAlign.Center,
                maxLines = 2

                )
            Spacer(modifier = Modifier.height(29.dp))
            Image(
                painter = painterResource(id = R.drawable.logo), // Reemplaza con tu logo
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Acción al hacer clic */ },
                colors = ButtonDefaults.buttonColors(containerColor = ZasColors.Blue),
                modifier = Modifier
                    .padding(top =24.dp)
            ) {
                Text(
                    text = "Comenzar",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el texto y el icono
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Icono de flecha
                    contentDescription = "Flecha hacia adelante",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                TextButton(onClick = { /* Acción al hacer clic */ }) {
                    Text(
                        text = "Iniciar sesión",
                        color = ZasColors.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                TextButton(onClick = { /* Acción al hacer clic */ }) {
                    Text(
                        text = "Registrarse",
                        color = ZasColors.Green,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

