package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel
import com.miel3k.masteringcomposepaging3.ui.theme.TangerineYellow

/**
 * Created by jmielczarek on 16/10/2022
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BeersContent(
    beersPagingItems: LazyPagingItems<BeerModel>,
    countText: String,
    onBeerTap: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = TangerineYellow,
                shape = RoundedCornerShape(bottomStart = 50f, bottomEnd = 50f),
            )
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Tap to taste!")
            AnimatedContent(
                targetState = countText,
                transitionSpec = {
                    addAnimation().using(
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(
                    text = targetCount,
                    style = TextStyle(fontSize = MaterialTheme.typography.h1.fontSize),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
    BeerList(
        modifier = Modifier.padding(top = 160.dp),
        beersPagingItems = beersPagingItems,
        onBeerTap = onBeerTap
    )
}

@ExperimentalAnimationApi
fun addAnimation(duration: Int = 800): ContentTransform {
    return slideInVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    ) with slideOutVertically(animationSpec = tween(durationMillis = duration)) { height -> -height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
}