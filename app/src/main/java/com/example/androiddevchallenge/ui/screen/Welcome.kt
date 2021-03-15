/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
fun Welcome(goToPage: (() -> Unit)? = null) {

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
    ) {
        Box(Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = welcomeBg),
                contentDescription = "welcome background"
            )

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = welcomeIllos),
                    contentDescription = "welcome image",
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 72.dp, start = 88.dp, bottom = 48.dp)
                        .offset(x = 40.dp),
                )
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
                        .padding(start = 16.dp, end = 16.dp)
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
                    onClick = { goToPage?.invoke() },
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
