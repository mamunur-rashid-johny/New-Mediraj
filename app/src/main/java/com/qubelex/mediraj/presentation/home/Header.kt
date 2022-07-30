package com.qubelex.mediraj.presentation.home


import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.qubelex.mediraj.R
import com.qubelex.mediraj.utils.nagivation.Screens


@Composable
fun Header(navController: NavController) {
    val configuration = LocalConfiguration.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://example.com/image.jpg")
                .crossfade(true)
                .build(),
            error = painterResource(R.mipmap.user_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .clickable {
                    navController.navigate(Screens.Profile.route)
                }
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    Text(
                        text = "Hi Mamunur Rashid Johnny 123654",
                        color = MaterialTheme.colors.onBackground,
                    )
                }
                else -> {
                    Text(
                        text = "Hi Mamunur Rashid Johnny 123654",
                        color = MaterialTheme.colors.onBackground,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.width(200.dp)
                    )
                }
            }
            Text(
                text = "What do you need...",
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground
            )
        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            BadgedBox(badge = { Badge(backgroundColor = Color.Green) }) {
                Icon(
                    tint = MaterialTheme.colors.onBackground,
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(
                            onClick = { navController.navigate(Screens.Notification.route) },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(
                                color = Color.Green.copy(0.5f),
                                bounded = false
                            )
                        )
                )
            }

        }
    }
}





