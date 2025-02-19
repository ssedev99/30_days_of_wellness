package com.example.daysofwellness

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daysofwellness.model.DaysOfWellness

@Composable
fun DaysOfWellnessList(
    modifier: Modifier = Modifier,
    daysOfWellnessList: List<DaysOfWellness>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = contentPadding
    ) {
        items(daysOfWellnessList) {
            DaysOfWellnessItem(
                daysOfWellness = it,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun DaysOfWellnessItem(
    modifier: Modifier = Modifier,
    daysOfWellness: DaysOfWellness
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Text(
                text = stringResource(daysOfWellness.day),
                fontSize = 24.sp
            )
            Text(
                text = stringResource(daysOfWellness.titleRes),
                fontSize = 20.sp,
            )
            Image(
                painter = painterResource(daysOfWellness.imageRes),
                contentDescription = null,
            )
            if (expanded) {
                Text(
                    text = stringResource(daysOfWellness.descriptionRes),
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview("DaysOfWellness Item")
@Composable()
fun DaysOfWellnessItemPreview() {
    val daysOfWellness = DaysOfWellness(
        R.string.day_1,
        R.string.day_1_title,
        R.drawable.day_1,
        R.string.day_1_description
    )
    DaysOfWellnessItem(daysOfWellness = daysOfWellness)
}
