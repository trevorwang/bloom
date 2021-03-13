package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes


@Composable
fun Home(navController: NavController? = null) {

    val themes = listOf(
        Pair("Desert chic", R.mipmap.img_10),
        Pair("Tiny terrariums", R.mipmap.img_9),
        Pair("Jungle vibes", R.mipmap.img_8),
        Pair("Easy care", R.mipmap.img_7),
        Pair("Statements", R.mipmap.img_6),
    )

    val templates = listOf(
        Pair(R.mipmap.img_5, "Monstera"),
        Pair(R.mipmap.img_4, "Aglaonema"),
        Pair(R.mipmap.img_3, "Peace lily"),
        Pair(R.mipmap.img_2, "Fiddle leaf tree"),
        Pair(R.mipmap.img_1, "Snake plant"),
        Pair(R.mipmap.img, "Pothos"),
    )


    Surface(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)) {
            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                value = "",
                onValueChange = { /*TODO*/ },
                placeholder = {
                    Row {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                        Text("Search", style = MaterialTheme.typography.body1)
                    }
                },
                modifier = Modifier
                    .height(56.dp)
                    .padding(end = 16.dp)
                    .border(1.dp, Color(0xFF9E9E9E), shapes.small)
                    .fillMaxWidth(), colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                )
            )

            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 16.dp)
            )


            LazyRow(
                Modifier
                    .height(136.dp)
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(themes) {
                    Card(
                        elevation = 1.dp,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f),
                        shape = shapes.small,
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = it.second),
                                contentDescription = it.first,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.height(96.dp)
                            )
                            Text(
                                text = it.first,
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier.fillMaxHeight(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

            }



            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Design your home garden", style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Icon(imageVector = Icons.Default.FilterList, contentDescription = "")
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                items(templates) {
                    Row(
                        Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Image(
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = it.first),
                            contentDescription = it.second,
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(1f)
                        )
                        Column(Modifier.padding(start = 16.dp)) {
                            Text(
                                text = it.second,
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                            Text(
                                text = "This is a description",
                                style = MaterialTheme.typography.body1,
                            )
                        }
                        Checkbox(
                            checked = true,
                            onCheckedChange = { /*TODO*/ },
                            modifier = Modifier.padding(start = 16.dp),
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = MaterialTheme.colors.background
                            )
                        )
                    }

                }

            }
        }


    }

}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreviewLight() {
    MyTheme {
        Home()
    }
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreviewDark() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
