package com.example.lab_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_5.ui.theme.Lab_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartaoVisita()
                }
            }
        }
    }
}

@Composable
fun CartaoVisita() {
    // Coluna externa para centralizar o Card na tela
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center, // Centraliza verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza horizontalmente
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Foto de perfil com gradiente
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color(0xFF667eea), Color(0xFF764ba2))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "JS",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Nome e cargo
                Text(
                    text = "João Silva",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )

                Text(
                    text = "Desenvolvedor Mobile",
                    fontSize = 16.sp,
                    color = Color(0xFF718096),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Linha decorativa
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(3.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color(0xFF667eea), Color(0xFF764ba2))
                            ),
                            shape = RoundedCornerShape(2.dp)
                        )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Informações de contato
                InfoLinha(
                    icone = Icons.Default.Phone,
                    texto = "(11) 99999-9999"
                )

                Spacer(modifier = Modifier.height(12.dp))

                InfoLinha(
                    icone = Icons.Default.Email,
                    texto = "joao.silva@email.com"
                )

                Spacer(modifier = Modifier.height(12.dp))

                InfoLinha(
                    icone = Icons.Default.Share,
                    texto = "@joaosilva.dev"
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Redes sociais
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RedeSocial("f", Color(0xFF1877F2))
                    RedeSocial("X", Color(0xFF000000))
                    RedeSocial("in", Color(0xFF0077B5))
                    RedeSocial("G", Color(0xFFDB4437))
                }
            }
        }
    }
}

@Composable
fun InfoLinha(icone: androidx.compose.ui.graphics.vector.ImageVector, texto: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icone,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF667eea)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = texto,
            fontSize = 16.sp,
            color = Color(0xFF4A5568)
        )
    }
}

@Composable
fun RedeSocial(nome: String, cor: Color) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(cor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = nome,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CartaoVisitaPreview() {
    Lab_5Theme {
        CartaoVisita()
    }
}