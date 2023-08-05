package com.example.myapplication.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun CircularExample(
    tracker: Float,
    circuleColors: List<Color> = listOf(
        colorResource(R.color.purple_700),
        colorResource(R.color.teal_200),
    ),
) {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .padding(8.dp),
        onDraw = {
            this.drawIntoCanvas {
                drawArc(
                    color = Color.Green,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 55f, cap = StrokeCap.Butt),
                    size = Size(size.width, size.height),
                )
                drawArc(
                    brush = Brush.linearGradient(colors = circuleColors),
                    startAngle = -90f,
                    sweepAngle = progress(tracker, 20f),
                    useCenter = false,
                    style = Stroke(width = 55f, cap = StrokeCap.Round),
                    size = Size(size.width, size.width),
                )
            }
        },
    )
}

fun progress(tracker: Float, progress: Float): Float {
    val totalProgress = (progress * 100) / tracker
    return ((360 * totalProgress) / 100)
}

@Preview
@Composable
private fun preview() {
    // CircularExample(tracker = 50f)
    val scope = rememberCoroutineScope()
    val progress = 1..100
    progress.forEach { p ->
        //   LaunchedEffect(key1 = p) {
        CircularExample(tracker = p.toFloat())
        //         delay(100)
        //    }
    }
}
