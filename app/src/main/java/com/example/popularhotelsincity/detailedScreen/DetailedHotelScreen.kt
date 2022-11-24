package com.example.popularhotelsincity.detailedScreen

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.cardview.widget.CardView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Scoreboard
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

import com.example.popularhotelsincity.R
import com.example.popularhotelsincity.detailedScreen.ui.theme.PopularHotelsInCityTheme
import com.example.popularhotelsincity.setText
import org.w3c.dom.Text

class DetailedHotelScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopularHotelsInCityTheme {
                // A surface container using the 'background' color from the theme

                    Greeting()

            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Greeting() {
    val context= LocalContext.current

    val activity=context.findActivity()
    val name=activity?.intent?.extras?.getString("name")
    val pic=activity?.intent?.extras?.getString("pic")
    val star=activity?.intent?.extras?.getInt("star")
    val score=activity?.intent?.extras?.getInt("score")

    Card(

        modifier = Modifier.wrapContentSize()



    ) {


        Column(
            modifier = Modifier

                .fillMaxWidth()
        ) {
            Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
            ) {
                GlideImage(
                    model = pic, contentDescription = null,
                    modifier = Modifier.height(minOf(300.dp)),
                    contentScale = ContentScale.Crop
                )
                Column() {


                    Text(
                        text = name.toString(),
                        color = MaterialTheme.colorScheme.background,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier


                            .padding(start = 12.dp, end = 20.dp)
                    )

                    Row(Modifier.padding(start = 12.dp)) {
                        if (star != null) {
                            repeat(star)
                            {
                                Icon(
                                    imageVector = Icons.Default.Star, contentDescription = null,
                                    tint = Color.Green
                                )
                            }
                        }

                    }
                }
            }

            Column(modifier = Modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)) {
                Text(
                    text = "Review Screen",
                    Modifier.padding(top = 10.dp, start = 12.dp),
                    fontWeight = FontWeight.Bold
                )
                Row(modifier = Modifier.padding(top = 10.dp, start = 12.dp)) {
                    Icon(imageVector = Icons.Filled.Message, contentDescription = null,
                        modifier = Modifier.size(height = 50.dp, width = 50.dp))
                    Column(modifier = Modifier.padding(start = 10.dp)) {

                            if (score != -1) {
                                if (score != null) {
                                    Text(
                                        color=if (score>60){
                                            Color.Green

                                        } else if(score>30){
                                            Color.Yellow
                                        } else{
                                            Color.Red
                                        },

                                        text = if (score>60){
                                            "Excellent"

                                        } else if(score>30){
                                            "Fair"
                                        } else{
                                            "Poor"
                                        },
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                        }

                        Text(text = "4553 Reviews")

                    }

                }

            }
        }
    }

}
fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PopularHotelsInCityTheme {
        Greeting()
    }
}