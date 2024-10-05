package com.atilsamancioglu.artbookcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atilsamancioglu.artbookcompose.model.Art

@Composable
fun ArtList(arts: List<Art>, navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primaryContainer))
    {
        items(arts) {
            ArtRow(art = it, navController=navController)
        }
    }
}

@Composable
fun ArtRow(art: Art,navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .clickable {
            navController.navigate(
                "details_screen/${art.id}"
            )
        }
    ) {
        Text(text = art.artName,
            //color = MaterialTheme.colorScheme.surfaceContainerLow,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = art.year.toString(),
            //color = MaterialTheme.colorScheme.surfaceContainerHigh,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(2.dp))
    }
}