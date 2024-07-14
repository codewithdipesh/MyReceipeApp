package com.example.myreceipeapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(category: Category){
    Log.d("DetailScreenCategoryFromComposable",category.toString())
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Log.d("CategoryName",category.strCategory)
        Text(text = "${category.strCategory}" ?:"Not Avilable", textAlign = TextAlign.Center)
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb) ,
            contentDescription ="ThumbNail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        Text(
            text = "${category.idCategoryDescription}"?: "Description Not available",
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )


    }
}