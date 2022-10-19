package com.bibek.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bibek.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
                   ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    if(count < 0 || count > 6) {
            count = 0
    }



    val imageId = imageIdProvider(count)
    val imageTitleId = imageTitleProvider(count)
    val imageDescriptionId  = imageDescriptionProvider(count)


    Column(
        modifier
            .fillMaxHeight()
            .padding(top = 100.dp, start = 25.dp, end = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        ImageSection(imageId= imageId)
        TextSection(imageTitleId = imageTitleId , imageDescriptionId = imageDescriptionId )

        Row(
            modifier
                .padding(6.dp)
                .fillMaxWidth(),
            horizontalArrangement =Arrangement.SpaceAround,
        ) {

            Buttons(name = "Previous"){count--}
            Buttons(name = "Next") {count++}
        }



    }
}

@Composable
fun ImageSection(
    modifier: Modifier = Modifier,
    imageId : Int
   ) {
    val image = painterResource(imageId)

    Box(
        modifier.border(BorderStroke( 2.dp, Color.DarkGray))


    ) {
        Image(painter = image,
            contentDescription = null,
            modifier.padding(25.dp)

        )

    }


}


@Composable
fun TextSection(
    modifier : Modifier  = Modifier,
    imageTitleId : Int ,
    imageDescriptionId : Int
) {
    Card(
        modifier
            .background(Color.White)
            .padding(15.dp),
        elevation = 10.dp,



    ) {
        Column(
            modifier.padding(15.dp)
        ) {

            Text(
                text = stringResource(id = imageTitleId),
                fontSize = 25.sp,
            )

            Text(
                text = stringResource(id = imageDescriptionId),
                fontWeight = FontWeight.Bold

            )

        }
    }
}


@Composable
fun Buttons(
    name : String ,
    onClick : () -> Unit

) {

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp)
    ) {

        Text(text = "$name",

        )
    }
}


private fun imageIdProvider(
    imageCount : Int

) : Int {
    return when(imageCount){
        1 -> R.drawable.img_5299
        2 -> R.drawable.img_5280
        3 -> R.drawable.img_5334
        4 -> R.drawable.img_5459
        5 -> R.drawable.img_5957
        6 -> R.drawable.img_6075
        else -> R.drawable.img_6076
    }


}

private fun imageTitleProvider(
    imageTitleCount : Int

) : Int {
    return when(imageTitleCount){
        1 -> R.string.lovers
        2 -> R.string.cats
        3 -> R.string.smiling_lovers
        4 -> R.string.grouped_photos
        5 -> R.string.college_time
        6 -> R.string.minion_purple
        else -> R.string.minion
    }


}

private fun imageDescriptionProvider(
    imageDescriptionCount : Int

) : Int {
    return when(imageDescriptionCount){
        1 -> R.string.desc1
        2 -> R.string.desc2
        3 -> R.string.desc3
        4 ->  R.string.desc4
        5 -> R.string.desc5
        6 ->  R.string.desc6
        else -> R.string.desc7
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
       ArtSpaceApp()
    }
}