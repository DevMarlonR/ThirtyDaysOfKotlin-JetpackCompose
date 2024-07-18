package com.example.daysofkotlin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DayButton(
    onClick: () -> Unit,
    dayNumberInt: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick,
        modifier = Modifier
            .padding(0.dp),
//            .size(height = 50.dp, width = 30.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(0.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        contentPadding = ButtonDefaults.ContentPadding,
    ) {
        Row (
            modifier = Modifier
                .size(height = 50.dp, width = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Text(
//                text = "1"
                text = dayNumberInt.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                onTextLayout = {},
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun DayButtonPreview() {
    DayButton(
        onClick = { /*TODO*/ },
        dayNumberInt = 1)
}