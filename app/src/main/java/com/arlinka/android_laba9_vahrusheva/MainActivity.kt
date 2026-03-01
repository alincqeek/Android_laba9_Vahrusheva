package com.arlinka.android_laba9_vahrusheva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arlinka.android_laba9_vahrusheva.data.Datasource
import com.arlinka.android_laba9_vahrusheva.model.Game
import com.arlinka.android_laba9_vahrusheva.ui.theme.Android_laba9_vahrushevaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_laba9_vahrushevaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameCatalogApp()
                }
            }
        }
    }
}

@Composable
fun GameCatalogApp() {
    val games = Datasource().loadAnimeList()
    var currentIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameCard(game = games[currentIndex], modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = {
                    currentIndex = if (currentIndex - 1 < 0) games.size - 1 else currentIndex - 1
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Назад")
            }
            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % games.size
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Вперед")
            }
        }
    }
}

@Composable
fun GameCard(game: Game, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(game.imageResourceId),
                contentDescription = stringResource(game.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(game.titleResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(game.descriptionResourceId),
                modifier = Modifier.padding(16.dp, end = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}