package com.example.daysofkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysofkotlin.components.DayButton
import com.example.daysofkotlin.components.DayCard
import com.example.daysofkotlin.model.Days
import com.example.daysofkotlin.ui.theme.DaysOfKotlinTheme
import com.example.daysofkotlin.ui.theme.pinkGradient
import com.example.daysofkotlin.ui.theme.purpleGradient
import com.example.daysofkotlin.ui.theme.salmGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysOfKotlinApp(modifier: Modifier = Modifier) {
    var visibleDay: Int by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .shadow(elevation = 10.dp)
                    .clip(shape = RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                salmGradient,
                                pinkGradient,
                                purpleGradient
                            )
                        )
                    )   ,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(id = R.string.thirteen_days_of),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            onTextLayout = {}
                        )
                        Text(
                            text = stringResource(id = R.string.kotlin),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            onTextLayout = {}
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                salmGradient,
                                pinkGradient,
                                purpleGradient
                            )
                        )
                    ),
                tonalElevation = 100.dp,
                containerColor = Color.Transparent,
                actions = {
                    LazyRow {
                        items(30) {
                            DayButton(
                                onClick = {
                                    visibleDay = it
                                    println(it+1)
                                },
                                dayNumberInt = (it+1)
                            )
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DayCard(day = Days.days[visibleDay])
        }

    }
}

@Preview
@Composable
fun DayCardPreview() {
    DaysOfKotlinTheme {
        DaysOfKotlinApp()
    }
}