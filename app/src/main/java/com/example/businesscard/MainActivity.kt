package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.MailOutline
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.LightGrayCustom
import com.example.businesscard.ui.theme.MediumBlueCustom
import com.example.businesscard.ui.theme.DarkBlueCustom
import com.example.businesscard.ui.theme.LightBlueCustom
import com.example.businesscard.ui.theme.DarkYellowCustom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(name = "Courtney Hoppus", role = "Student Developer")
                }
            }
        }
    }
}

@Composable
fun PersonalDetails(name: String, role: String) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier.background(DarkBlueCustom),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = image,
            contentDescription = "android logo",
            modifier = Modifier.height(100.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = LightBlueCustom,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        Text(
            text = role,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = DarkYellowCustom,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}

@Composable
fun ContactMethod(icon: ImageVector, method: String, iconDescription: String) {
    Row(
        modifier = Modifier
            .background(MediumBlueCustom)
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            icon,
            contentDescription = "contact icon - $iconDescription"
        )
        Text(
            text = method,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun ContactMethodList() {
    Column {
        val modifier = Modifier.height(4.dp)
        val textMessage = "Text Message"
        val socialMedia = "Social Media"
        val emailAddress = "Email Address"
        Spacer(modifier)
        ContactMethod(Icons.Sharp.Face, textMessage, "$textMessage icon")
        Spacer(modifier)
        ContactMethod(Icons.Sharp.Favorite, socialMedia, "$socialMedia icon")
        Spacer(modifier)
        ContactMethod(Icons.Sharp.MailOutline, emailAddress, "$emailAddress icon")
    }
}

@Composable
fun BusinessCard(name: String, role: String) {
    Column(
        modifier = Modifier
            .background(LightGrayCustom)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        PersonalDetails(name, role)
        ContactMethodList()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(name = "Courtney Hoppus", role = "Student Developer")
    }
}
