package com.arlinka.android_laba9_vahrusheva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animate
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arlinka.android_laba9_vahrusheva.model.Game
import com.arlinka.android_laba9_vahrusheva.ui.theme.Android_laba9_vahrushevaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_laba9_vahrushevaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}


@Composable
fun GameCard(game: Game, modifier: Modifier){
    Card(modifier=modifier){
        Column() {
            Image(
                painter = painterResource(game.imageResourceId),
                contentDescription = stringResource(game.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(game.titleResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall)

            Text(text = stringResource(game.descriptionResourceId),
                modifier = Modifier.padding(16.dp, end = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.bodyMedium)
            @Composable
            fun GameList(gameList:List<Game>,modifier: Modifier= Modifier){
                LazyColumn(modifier=modifier) {
                    items(gameList){ game ->
                        GameCard(
                            game =game,
                            modifier= Modifier.padding(8.dp)
                        )

                    }
                }
            }
        }
    }
}