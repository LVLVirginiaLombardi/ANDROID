package com.example.myappwithmvvm.ui.theme.addname.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myappwithmvvm.R
import com.example.myappwithmvvm.ui.theme.addname.presentation.intents.AddNameIntent
import com.example.myappwithmvvm.ui.theme.addname.presentation.results.AddNameResult
import com.example.myappwithmvvm.ui.theme.addname.presentation.viewmodels.AddNameViewModel

@ExperimentalMaterial3Api
@Composable
fun AddNameScreen(viewModel: AddNameViewModel) {
    AddName(viewModel)
}

@ExperimentalMaterial3Api
@Composable
fun AddName(viewModel: AddNameViewModel) {
    Column {
        HeaderSection()
        Content(viewModel)
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(MaterialTheme.colorScheme.primary)
            .padding(20.dp)

    ) {
        LogoImage()
        SectionTitle("Add Name App",
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun SectionTitle(text: String, color: Color, style: TextStyle) {
    Text(
        text,
        color = color,
        style = style,
        modifier =
        Modifier
            .padding(top = 15.dp, start = 16.dp)
    )
}

@Composable
fun LogoImage() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_foreground
        ),
        contentDescription = "My App Logo",
        modifier =
        Modifier
            .padding(horizontal = 16.dp)
            .size(64.dp)
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.tertiary
            )

    )
}

@ExperimentalMaterial3Api
@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onAddItem: () -> Unit,
    modifier: Modifier,
    color: Color
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Name") },
            textStyle = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            ),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = color,
                cursorColor = Color.Black,
                containerColor = Color.LightGray
            ),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = onAddItem,
            modifier = Modifier.padding(top = 6.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.round_person_add_alt_1_24
                ),
                contentDescription = "Add Button",
                tint = Color.DarkGray
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Content(viewModel: AddNameViewModel) {
    var newItemText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(18.dp)

    ) {
        MyTextField(
            value = newItemText,
            onValueChange = { newItemText = it },
            onAddItem = {
                viewModel.onIntent(AddNameIntent.AddItem(newItemText))
                newItemText = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(22.dp))

        viewModel.items.value?.let {
            ItemList(items = it) { index ->
                viewModel.onIntent(AddNameIntent.RemoveItem(index))
            }
        }
    }
}

@Composable
fun ItemList(items: List<String>, onItemRemove: (Int) -> Unit) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            ItemRow(
                text = item,
                onRemove = { onItemRemove(index) }
            )
        }
    }
}

@Composable
fun ItemRow(text: String, onRemove: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text, modifier = Modifier.weight(1f))
        IconButton(onClick = onRemove) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete Button",
                tint = Color.DarkGray
            )
        }
    }
}


