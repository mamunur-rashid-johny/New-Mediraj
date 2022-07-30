package com.qubelex.mediraj.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.qubelex.mediraj.utils.data_source.DemoDataSource
import com.qubelex.mediraj.utils.data_source.services
import com.qubelex.mediraj.utils.nagivation.Screens
import com.qubelex.mediraj.utils.util.exhaustive

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {
        // Header(navController = navController)
        LazyVerticalGrid(
            columns = GridCells.Adaptive(80.dp), contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) { Header(navController = navController) }

            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "Services",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
            items(services.size) { index ->
                ServiceItem(service = services[index]){
                    when(services[index].id){
                        1->{
                            navController.navigate(Screens.Medicine.route)
                        }
                        2->{
                           navController.navigate(Screens.Diagnostic.route)
                        }
                        3->{
                            navController.navigate(Screens.Pathology.route)
                        }
                        4->{
                            navController.navigate(Screens.Clinic.route)
                        }
                        5->{
                            navController.navigate(Screens.Doctor.route)
                        }
                        6->{
                            navController.navigate(Screens.Surgical.route)
                        }
                        7->{
                            navController.navigate(Screens.Blood.route)
                        }
                        8->{
                            navController.navigate(Screens.Ambulance.route)
                        }
                        9->{
                            navController.navigate(Screens.RealTimeMedicine.route)
                        }
                    }
                }
            }

            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    ImageSlider(slides = DemoDataSource.dataImageSlider)
                }
            }

        }
    }
}

