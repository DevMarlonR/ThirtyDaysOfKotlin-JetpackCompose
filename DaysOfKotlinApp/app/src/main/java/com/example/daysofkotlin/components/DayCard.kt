package com.example.daysofkotlin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysofkotlin.R
import com.example.daysofkotlin.model.Day
import com.example.daysofkotlin.model.Days


@Composable
fun DayCard(day: Day, modifier: Modifier = Modifier) {
    Card (
        elevation = CardDefaults.cardElevation(3.dp),
        modifier = Modifier
            .widthIn(max = 1000.dp)
            .height(550.dp)
    ) {
        Column (modifier = modifier) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.day),
                    onTextLayout = {}
                )
                Text(
                    text = formattedData(day.dayNumber),
                    fontWeight = FontWeight.Bold,
                    onTextLayout = {}
                )
            }
            Text(
                text = stringResource(id = day.nameRes),
                modifier = Modifier.padding(start = 10.dp),
                onTextLayout = {}
            )
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .heightIn(max = 250.dp)
                    .widthIn(max = 1000.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = day.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp)

            ) {
                Text(
                    text = stringResource(id = day.describeRes),
                    onTextLayout = {}
                )
            }
        }
    }
}

fun formattedData(day: Int): String {
    return if(day < 10) " 0$day" else " $day"
}

@Preview
@Composable
fun DayCardPreview(){
    DayCard(day = Days.days[1])
}