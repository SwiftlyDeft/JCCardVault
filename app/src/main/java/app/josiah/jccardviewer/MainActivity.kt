package app.josiah.jccardviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.josiah.jccardviewer.models.CreditCardModel
import app.josiah.jccardviewer.service.CreditCardService
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Hello")
        }
    }
}

fun TestAPIConnection() {
    // Test
    val service = CreditCardService()

    // Define onSuccess and onFailure callbacks
    val onSuccess: (List<CreditCardModel>) -> Unit = { creditCards ->
        println("Received credit cards:")
        creditCards.forEach { card ->
            println("ID: ${card.id}, Number: ${card.creditCardNumber}")
        }
    }

    val onFailure: (String) -> Unit = { error ->
        println("Error occurred: $error")
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting("World")
}