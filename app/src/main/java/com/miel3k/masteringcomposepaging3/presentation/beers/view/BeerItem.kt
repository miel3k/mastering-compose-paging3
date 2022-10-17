package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.miel3k.masteringcomposepaging3.R
import com.miel3k.masteringcomposepaging3.ui.theme.DarkOrange
import com.miel3k.masteringcomposepaging3.ui.theme.DroverYellow
import com.miel3k.masteringcomposepaging3.ui.theme.WhiteSmoke

/**
 * Created by jmielczarek on 17/10/2022
 */
@Composable
fun BeerItem(name: String, description: String, imageUrl: String) {
    Box {
        Card(
            modifier = Modifier
                .height(160.dp)
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = 4.dp,
            backgroundColor = DroverYellow
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp),
                    backgroundColor = WhiteSmoke
                ) {
                    AsyncImage(
                        modifier = Modifier.padding(8.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                    )
                }
                Column(
                    Modifier
                        .height(IntrinsicSize.Max)
                        .padding(end = 8.dp)
                ) {
                    Text(text = name)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = description,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier.align(Alignment.CenterEnd),
            onClick = { },
            backgroundColor = DarkOrange
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_beer), contentDescription = "")
        }
    }
}