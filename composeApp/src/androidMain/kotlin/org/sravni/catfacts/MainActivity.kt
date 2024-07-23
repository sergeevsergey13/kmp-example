package org.sravni.catfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.FactModel
import presentation.FactController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactScreen()
        }
    }
}

@Composable
fun FactScreen() {
    val state = FactController.factFlow.collectAsState()

    FactSuccessView(facts = state.value)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FactSuccessView(facts: List<FactModel>) {
    Column(
        modifier = Modifier.background(Color.LightGray.copy(alpha = 0.5f))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { Spacer(modifier = Modifier.size(16.dp)) }

            items(
                items = facts,
                key = { it.id }
            ) { fact ->
                FactView(
                    modifier = Modifier.animateItemPlacement(),
                    factModel = fact
                )
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = { FactController.getNewFact() },
            content = { Text(text = "Get new fact") },
        )
    }
}

@Preview
@Composable
fun FactViewPreview() {
    val fact = FactModel("very interesting fact")
    FactView(factModel = fact)
}

@Composable
fun FactView(modifier: Modifier = Modifier, factModel: FactModel) {
    factModel.factText?.let {
        Card(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = it,
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp
            )
        }
    }
}

