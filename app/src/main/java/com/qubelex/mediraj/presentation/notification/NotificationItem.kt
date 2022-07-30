package com.qubelex.mediraj.presentation.notification

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qubelex.mediraj.R


@Composable
fun NotificationItem() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .clickable {  },
            elevation = 2.dp,
            shape = RoundedCornerShape(0.dp)
        ) {
           Row(modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp)) {
               Image(painter = painterResource(id = R.drawable.ic_message), contentDescription = null)
               Spacer(modifier = Modifier.width(10.dp))
              Column {
                  Text(text = "This is a notification item placeholder to see how it look when it placed in design section.", color = MaterialTheme.colors.onBackground)
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(text = "Jul 3, 10:05 AM", color = MaterialTheme.colors.onBackground.copy(0.5f), fontSize = 12.sp)
              }
           } 
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationItemPreview() {
    NotificationItem()
}
