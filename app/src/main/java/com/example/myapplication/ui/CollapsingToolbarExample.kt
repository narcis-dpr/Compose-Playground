package com.example.myapplication.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.myapplication.hlpers.City

@Composable
fun CollapsingToolbarExample() {
    val height = 260.dp
    val titleToolbar = 50.dp
    val scrollState: ScrollState = rememberScrollState(0)
    val headerHeight = with(LocalDensity.current) {
        height.toPx()
    }
    val toolbarHeight = with(LocalDensity.current) {
        titleToolbar.toPx()
    }
    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0xFF6D38CA)),
                    startY = 1 * headerHeight / 5,
                ),
            ),
    ) {
        CollapsingHeader(scrollState, headerHeight)
        FactsAboutNewYork(scrollState)
        OurTookBar(scrollState, headerHeight, toolbarHeight)
       // City()
    }
}

@Composable
fun OurTookBar(scrollState: ScrollState, headerHeight: Float, toolbarHeight: Float) {
    val transitionState = MutableTransitionState<Boolean>(true)
    AnimatedVisibility(visibleState = transitionState,
        enter = fadeIn(animationSpec = tween(200)),
        exit = fadeOut(tween(200))
    ) {
//
    }
}

@Composable
fun FactsAboutNewYork(scrollState: ScrollState) {
    TODO("Not yet implemented")
}

@Composable
fun CollapsingHeader(scrollState: ScrollState, headerHeight: Float) {
    TODO("Not yet implemented")
}
