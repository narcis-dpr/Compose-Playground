package com.example.myapplication.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CityTabCarousel() {
    val pages: MutableList<String> =
        arrayListOf("Spain", "New York", "Tokyo", "Switzerland", "Paris")
    val pagerState = rememberPagerState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column {
//
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator()
            },
            edgePadding = 0.dp,
            containerColor = Color(
                context.resources.getColor(R.color.white, null),
            ),
        ) {
            pages.forEachIndexed { index, title ->
                val isSelected = pagerState.currentPage == index
                Tab(
                    selected = isSelected,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { title[index]}
                )
//
            }
        }
        HorizontalPager(
            pageCount = pages.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
                .background(Color.White),
        ) { page ->
            Text(
                text = "Displact City Name: ${pages[page]}",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(textAlign = TextAlign.Center),
            )
        }
    }
}

@Preview
@Composable
private fun preview() {
    MyApplicationTheme {
        CityTabCarousel()
    }
}
