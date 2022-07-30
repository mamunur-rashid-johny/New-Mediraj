package com.qubelex.mediraj.presentation.login

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ireward.htmlcompose.HtmlText
import com.qubelex.mediraj.R
import com.qubelex.mediraj.presentation.ui.theme.Alabaster
import com.qubelex.mediraj.presentation.ui.theme.AzureBlue
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen
import com.qubelex.mediraj.utils.nagivation.Screens
import java.lang.Exception

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel:LoginViewModel = hiltViewModel()
    val htmlString = """
        <font color=#808080>By tapping continue, you agree to </font> 
        <font color =#009719> Terms and Conditions</font>
        <font color=#808080> and </font><font color =#009719>Privacy Policy
        </font><font color = #808080> of MediRaj.<font>
    """

    var text by remember { mutableStateOf("") }
    val context = LocalContext.current
    LaunchedEffect(key1 = true ){
        viewModel.loginEvent.collect{event->
            when(event){
                is LoginViewModel.LoginEvent.OpenLink->{
                    try {
                        val intent = Intent(Intent.ACTION_VIEW,Uri.parse(event.link))
                        context.startActivity(intent)
                    }catch (exp:Exception){
                       Toast.makeText(context,exp.localizedMessage,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .padding(top = 60.dp, start = 20.dp, end = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Enter your mobile number",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .background(Color.White)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_phone),
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                        .width(2.dp)
                        .background(Color.LightGray)
                )
                Text(
                    text = "+88",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.Black
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it.take(11)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.Black,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp
                    ),
                    placeholder = {
                        Text(
                            text = "01XXXXXXXXX", fontSize = 18.sp,color = Color.Black.copy(0.5f))
                    },
                    trailingIcon = {
                        if (text.isNotEmpty()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_clear),
                                contentDescription = null,
                                modifier = Modifier.clickable { text = "" })
                        }
                    },
                    modifier = Modifier.offset(x = (-10).dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screens.Home.route)
            }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = ForestGreen
            )
        ) {
            Text(text = "Continue", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "OR",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(AzureBlue)
                .clickable {
                    navController.popBackStack()
                    navController.navigate(Screens.OtpVerify.route)
                }
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 20.dp)
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Continue with Facebook",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        HtmlText(
            text = htmlString,
            style = TextStyle(fontSize = 14.sp, textAlign = TextAlign.Center),
            modifier = Modifier.clickable(
                onClick = {viewModel.openLinkEvent()},
                interactionSource = remember { MutableInteractionSource()},
                indication = null
            )
        )


    }
}
