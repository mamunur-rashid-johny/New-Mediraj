package com.qubelex.mediraj.presentation.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen

@Composable
fun NotificationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
    ) {
        val testItem = listOf(1,2,3,4,5,6,7,8,9,10)

        LazyColumn(modifier = Modifier.padding(bottom = 20.dp).fillMaxSize()){
            items(testItem){it->
               NotificationItem()
                if (it !=testItem.size){
                    Divider()
                }
            }
        }
    }
}
