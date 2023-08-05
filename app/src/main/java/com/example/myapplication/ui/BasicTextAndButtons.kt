package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textFieldExample() {
    TextField(
        value = "hello",
        onValueChange = {},
        label = { Text(text = stringResource(id = R.string.app_name)) },
        modifier = Modifier.fillMaxWidth().padding(top = 2.dp, bottom = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
        ),
    )
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = { }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "its button",
            modifier = Modifier.size(20.dp),
        )
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(top = 10.dp),
        )
    }
}

@Composable
fun CornerCutShapedButton() {
    Button(
        onClick = { },
        shape = CutCornerShape(10.dp),
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
    ) {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Composable
fun RoundCornerShapeButton() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
    ) {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Composable
fun ElevatedButtonExample() {
    Button(
        onClick = { },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp,
        ),
    ) {
        Text(text = stringResource(id = R.string.app_name))
//
    }
}

@Composable
fun ImageViewExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "",
        modifier = Modifier.padding(top = 20.dp, bottom = 8.dp),
    )
}

@Preview
@Composable
private fun prev() {
    MyApplicationTheme {
        Column {
            ButtonWithIcon()
            textFieldExample()
            CornerCutShapedButton()
            RoundCornerShapeButton()
            ImageViewExample()
        }
    }
}
