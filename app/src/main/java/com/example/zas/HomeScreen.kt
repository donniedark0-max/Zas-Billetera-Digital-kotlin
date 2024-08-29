package com.example.zas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zas.ui.theme.ZasColors

@Preview(showBackground = true)
@Composable
fun HomeScreen(paddingValues: PaddingValues = PaddingValues()){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.Black)
    ) {
        // Total Balance
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = ZasColors.LightGray,
            shape = RoundedCornerShape(10.dp),) {
            Column(
                modifier = Modifier
                    .padding(vertical =30.dp, horizontal = 16.dp)
            ) {
                Text("Saldo Total", color = ZasColors.Gray,
                    modifier = Modifier
                        .padding(bottom = 6.dp))

                    Text(
                        text = "S/. 2,450.75",
                        color = ZasColors.Gray,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 26   .sp
                    )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ){

                Text("+S/. 250 este mes", color = ZasColors.Green,
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
                    Button(
                        onClick = { /*TODO*/ },modifier = Modifier
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = ZasColors.Blue)
                    ) {
                        Text("Añadir Dinero", color = Color.White)
                    }
                }
            }
        }

        // Send, Cards, Top Up
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ActionItem(icon = Icons.Filled.Send, text = "Enviar")
            ActionItem(icon = Icons.Filled.CreditCard, text = "Tarjetas")
            ActionItem(icon = Icons.Filled.AddCircle, text = "(Recargar?)")
        }

        // Transactions
        Text("Transacciones Recientes",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp, top = 26.dp))

        TransactionItem(
            icon = Icons.Filled.CreditCard,
            circleColor = ZasColors.Blue,
            amount = "-S/. 35.99",amountColor = ZasColors.Gray,
            description = "Amazon Purchase",
            date = "May 15, 2024"
        )

        TransactionItem(
            icon = Icons.Filled.Send,
            circleColor = ZasColors.Green,
            amount = "+S/. 120.00",
            amountColor = ZasColors.Green,
            description = "Recibido de Jhon",
            date = "May 14, 2024"
        )

        TransactionItem(
            icon = Icons.Filled.CreditCard,
            circleColor = Color(0xFFF7DC6F),
            amount = "-S/. 9.99",
            amountColor = ZasColors.Gray,
            description = "Suscripción renovada",
            date = "May 13, 2024"
        )
    }
}

@Composable
fun ActionItem(icon: ImageVector, text: String) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .width(105.dp),
        color = ZasColors.LightGray,
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(icon, contentDescription = text, tint = ZasColors.Blue)
            Text(text, color = ZasColors.Gray,
                modifier = Modifier.padding(top = 5.dp))
        }
    }
}

@Composable
fun TransactionItem(
    icon: ImageVector,
    circleColor: Color,
    amount: String,
    amountColor: Color,
    description: String,
    date: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = ZasColors.LightGray,
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    icon,
                    contentDescription = description,
                    modifier = Modifier
                        .size(40.dp)
                        .background(circleColor, CircleShape)
                        .padding(8.dp),
                    tint = Color.White
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(description, color = ZasColors.Gray,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp)
                    Text(date, color = ZasColors.Gray, fontWeight = FontWeight.Light)
                }
            }

            // Amount
            Text(
                text = amount,
                color = amountColor,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 15.sp)
            }


    }
}