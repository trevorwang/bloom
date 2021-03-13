package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.shapes


@Composable
fun Welcome() {

    val isLightTheme = MaterialTheme.colors.isLight
    val welcomeBg =
        if (isLightTheme) R.drawable.ic_light_welcome_bg
        else R.drawable.ic_dark_welcome_bg
    val welcomeIllos =
        if (isLightTheme) R.drawable.ic_light_welcome_illos
        else R.drawable.ic_dark_welcome_illos
    val logo = if (isLightTheme) R.drawable.ic_light_logo
    else R.drawable.ic_dark_logo
    Surface(
        Modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ) {
        Box(Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = welcomeBg),
                contentDescription = "welcome background"
            )


            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.size(72.dp))


                Row {

                    Spacer(modifier = Modifier.size(88.dp))
                    Image(
                        painter = painterResource(id = welcomeIllos),
                        contentDescription = "welcome image"
                    )
                }

                Spacer(modifier = Modifier.height(48.dp))

                Image(
                    painter = painterResource(id = logo),
                    contentDescription = "logo"
                )

                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onPrimary
                )

                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    ),
                    shape = shapes.medium,
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Create account", style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))



                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = if (isLightTheme) pink900 else Color.White,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }

}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewLight() {
    MyTheme {
        Welcome()
    }
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreviewDark() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}
