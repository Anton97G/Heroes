package com.example.herois

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herois.ui.theme.HeroisTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            Column(modifier = Modifier
                .background(Color.DarkGray)
                .padding(top = 10.dp)
                ) {
                Text(
                    text = "HEROES IN WARCRAFT",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )



            
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.DarkGray)
            ){

                
                itemsIndexed(
                    cards
                ){
                    _, item ->
                    ListCard(cardData = item)
                    
                }
            }
            
            
        }
    }
}
}


data class CardData(val title: String, val description: String, val imageId: Int)
val cards = listOf(
    CardData("Артас Менетил", "владеет мечом, который способен превращать живых существ в нежить.", R.drawable.person1),
    CardData("Тралл", "мастерства в боевых искусствах, способность контролировать стихии и возглавлять орды орков.", R.drawable.person2),
    CardData("Джайна Праудмур", "могущественная маг, способная создавать магические барьеры и призывать элементалей.", R.drawable.person3),
    CardData("Сильвана Ветрокрылая", "лучница, обладающая уникальной способностью контролировать мертвых.", R.drawable.person4),
    CardData("Иллидан Ярость Бури", "демонический охотник, способный обладать несколькими формами и выраженной силой.", R.drawable.person5),
    CardData("Медив", "могущественный маг и провидец, способный открывать порталы в другие миры.", R.drawable.person6),
    CardData("Утер Лайтбрингер", "паладин, способный лечить и блокировать магию.", R.drawable.person7),
    CardData("Вариан Врекзас", "боец, владеющий двумя мечами и способный вызывать гнев.", R.drawable.person8),
    CardData("Тичондрий", "могущественный демон, способный манипулировать магией теней.", R.drawable.person9),
    CardData("Гул'дан", "орочий шаман, который обратился к магии теней и обладает силой контроля над демонами.", R.drawable.person10),
)




@Composable



 fun ListCard(cardData: CardData){

var isExpanded by remember {
    mutableStateOf(false)
}


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.background(Color.Gray)
        ){
            Row(

                verticalAlignment = Alignment.CenterVertically,

                ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(200f),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = cardData.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                    Text(modifier = Modifier.clickable {
                            isExpanded = !isExpanded
                    }, maxLines = if (isExpanded )10 else 1,

                        text = cardData.description,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center)


                }
                Image(
                    painter = painterResource(id = cardData.imageId),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}





