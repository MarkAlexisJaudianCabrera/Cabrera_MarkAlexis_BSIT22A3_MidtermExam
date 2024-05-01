package com.example.cabrera_markalexis_bsit22a3_midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cabrera_markalexis_bsit22a3_midtermexam.ui.theme.Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp(){
    Column {
        Row (
            modifier = Modifier
                .background(color = Color.Blue)
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            HeaderBackground()
        }
        Row (
            modifier = Modifier
                .background(color = Color.DarkGray)
                .padding(all = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight(.92f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            SwitchScreen()
        }
        Row (
            modifier = Modifier
                .background(color = Color.Blue)
                .padding(all = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center
        ){
            Footer()
        }
    }





}

@Composable
fun SwitchScreen(){
    var clicked by remember{ mutableStateOf(0) }
    //var QuizDone by remember{mutableStateOf(false)}
    //BodyContentHome()
    //BodyContentAbout()
    BodyContentGame()
}

@Composable
fun BodyContentHome(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row{
            //Image Who's that Pokemon?
            Image(
                painter = painterResource(id = R.drawable.wtpokemon),
                contentDescription = "WTPokemon_Home"
            )
        }
        Row {
            //Start now Button
            Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.startnow_btn))
            }
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
            )
        }
        Row {
            //About Button
            Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.about_btn))
            }
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}

@Composable
fun BodyContentAbout(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Row {
            //Image Who's that Pokemon?
            Image(
                painter = painterResource(id = R.drawable.wtpokemon),
                contentDescription = "WTPokemon_Home"
            )
        }
        Row {
            //Name, Section, Subject.
            Text(
                text = "Name: Mark Alexis Jaudian Cabrera\nSection: BSIT-22A3\nSubject: Mobile Computing",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .wrapContentSize(Alignment.TopCenter)
                    .align(Alignment.Top)
            )
        }
        Row {
            //Description about the game.
            Text(
                text = "This game was created by the use of Android Studio Application."+
                        " The things that I used in this code are Text, TextField, Column,"+
                        " Row, and some modifier to make my UI to be aligned into the center.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .wrapContentSize(Alignment.TopCenter)
                    .align(Alignment.Top)
                    .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            )
        }
        Row {
            //Back Button
            Button(
                onClick = {}
            ) {
                Text(stringResource(R.string.back_btn))
            }
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}

@Composable//dito nangyayari yung pagdisplay ng POKEMON
fun BodyContentGame(modifier: Modifier = Modifier) {
    var clicked by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.pikachu
        2 -> R.drawable.bulbasaur
        else -> R.drawable.squirtle
    }
    val pokemonName = when (result) {
        1 -> R.string.pikachu
        2 -> R.string.bulbasaur
        else -> R.string.squirtle
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxHeight(.3f)
                .fillMaxWidth(.8f)
        ){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString()
            )
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(20.dp)
            )
        }
        Row {
            val answer = remember { mutableStateOf("") }

            TextField(
                value = answer.value, // Set the current value from the state variable
                onValueChange = { answer.value = it }, // Update state on value change
                label = { Text("Enter your answer..") },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
                )
        }
        Row {
            Column {
                Button(onClick = {}){
                    Text(stringResource(R.string.check_btn))
                }
            }
            Column {
                Button(onClick = {}){
                    Text(stringResource(R.string.correct))
                }
            }
        }
        Row {
            Column {
                Button(
                    onClick = {}
                ){
                    Text(stringResource(R.string.prev_btn))
                }
            }
            Column {
                Button(
                    onClick = {clicked = 3}
                ){
                    Text(stringResource(R.string.exit_btn))
                }
            }
            Column {
                Button(//dito nangyayari yung pagbigay ng randomise numbers from 1-6
                    onClick = {
                        result = (1..3).random()
                    }
                ) {//since naglagay ng button ung text yung nagsisilbi kung para saan yung button
                    Text(stringResource(R.string.next_btn))
                }
                Spacer(//para siyang margin para sa button
                    modifier = Modifier
                        .height(16.dp)
                )
            }
        }
    }
    //kung 1 = check
    //kung 2 = prev
    //kung 3 = exit
    //kung 4 = next
    if(clicked == 1){
        //
    }else if (clicked == 2){
        //
    }else if (clicked == 3){
        BodyContentHome()
    }else if (clicked == 4){
        //
    }
}

@Composable
fun BodyContent(){
    SwitchScreen()
}

@Composable
fun HeaderBackground(){
    Row {
        Column {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "pokeball-1",
                modifier = Modifier
                    .height(80.dp)
                    .align(Alignment.Start)
                    .padding(vertical = 8.dp)
            )
        }
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.pokemon),
                    contentDescription = "pokemon",
                    modifier = Modifier
                        .height(80.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 35.dp)
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.quiz_game),
                    contentDescription = "quiz_game",
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "pokeball-2",
                modifier = Modifier
                    .height(80.dp)
                    .align(Alignment.End)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun Footer(){
    Column {
        Row {
            Text(
                text = "All Rights Reserved 2024. @PokemonQuizGame!",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .wrapContentSize(Alignment.TopCenter)
                    .align(Alignment.Top)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme {
        MainApp()
    }
}