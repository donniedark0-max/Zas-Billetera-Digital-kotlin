package com.example.zas

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.zas.ui.theme.ZasColors

@Preview(showBackground = true)
@Composable
fun CreditCardScreen(paddingValues: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.Black)
    ) {
        // Slider o carrusel de tarjetas
        CardCarousel()

        // Card Actions
        CardActions()

        // Botón Agregar nueva tarjeta
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ZasColors.Blue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = "Agregar tarjeta"
            )
            Spacer(
                modifier = Modifier.width(
                    8.dp
                )
            )
            Text(
                "Agregar nueva tarjeta",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}

@Composable
fun CardCarousel() {
    // Implementa tu lógica de slider o carrusel aquí// Puedes usar una librería como Accompanist Pager o implementar tu propia lógica

    // Ejemplo con dos tarjetas estáticas
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .horizontalScroll(rememberScrollState(),)
    ) {
        CreditCardItem(
            cardType = "Visa",
            cardNumber = "**** **** **** 1234",
            cardHolder = "Juan Perez",
            expiryDate = "12/24",
            gradientColors = listOf(
                Color(0xFF64B5F6),
                Color(0xFF2196F3)
            ) // Azul
        )
        Spacer(modifier = Modifier.width(16.dp))
        CreditCardItem(
            cardType = "Mastercard",
            cardNumber = "**** **** **** 5678",
            cardHolder = "Juan Perez",
            expiryDate = "12/24",
            gradientColors = listOf(
                Color(0xFFEF5350),
                Color(0xFFE53935)
            ) // Rojo
        )
    }
}

@Composable
fun CreditCardItem(
    cardType: String,
    cardNumber: String,
    cardHolder: String,
    expiryDate: String,
    gradientColors: List<Color>
) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .background(Brush.horizontalGradient(gradientColors),
                shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),


            ) {
                Icon(
                    Icons.Filled.CreditCard,
                    contentDescription = "Card",
                    tint = Color.White,
                    modifier = Modifier.size(42.dp)
                )
                Spacer(
                    modifier = Modifier.weight(
                        1f
                    )
                )
                Text(
                    "Zas $cardType",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                cardNumber,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 25.dp),
                fontSize = 23.sp,
                fontWeight = FontWeight.ExtraBold

            )
            Spacer(
                modifier = Modifier.weight(
                    1f
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                Text(cardHolder, color = ZasColors.LightGray,
                    fontSize = 15.sp
                )
                Spacer(
                    modifier = Modifier.weight(
                        1f
                    )
                )
                Text(expiryDate, color = ZasColors.LightGray,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun CardActions() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CardActionItem(
                icon = Icons.Filled.Visibility,
                text = "Ver detalles",
                modifier = Modifier.weight(1f)
            )
            CardActionItem(
                icon = Icons.Filled.Lock,
                text = "Bloquear Tarjeta",
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            CardActionItem(
                icon = Icons.Filled.Settings,
                text = "Configurar limites",
                modifier = Modifier.weight(1f)
            )
            CardActionItem(
                icon = Icons.Filled.Send,
                text = "Transferir Saldo",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CardActionItem(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .padding(8.dp),
        color = ZasColors.LightGray,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(icon, contentDescription = text, tint = ZasColors.Blue, modifier = Modifier.size(40.dp))
            Text(text, color = ZasColors.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}