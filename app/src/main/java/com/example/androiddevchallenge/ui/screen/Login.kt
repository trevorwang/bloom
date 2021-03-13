package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes


@Composable
fun Login() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(Modifier.background(color = MaterialTheme.colors.background)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(152.dp))
            Text(
                text = "Log in with email", style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email, onValueChange = { /*TODO*/ },
                placeholder = {
                    Text(text = "Email address")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF9E9E9E), shapes.small)
                    .height(56.dp),
                textStyle = MaterialTheme.typography.body1,
                shape = RoundedCornerShape(4.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            //"Password(8+ characters)"
            TextField(
                value = password,
                placeholder = {
                    Text(text = "Password(8+ characters)")
                },
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .height(56.dp)
                    .border(1.dp, Color(0xFF9E9E9E), shapes.small)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            val hint = buildAnnotatedString {
                append("By clicking below, you agree to our ")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Terms of Use")
                }

                append(" and consent to our ")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Privacy Policy")
                }
                append(".")
            }

            Text(
                text = hint,
                style = MaterialTheme.typography.body2
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
                    text = "Log in", style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }


}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewLight() {
    MyTheme {
        Login()
    }
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LoginPreviewDark() {
    MyTheme(darkTheme = true) {
        Login()
    }
}
