package rakib.hasan.practice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationPage(){
    val tabItems = listOf("Home", "Product", "Setting")

    var selectedItem = remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text(text = "Bottom Appbar")})
        },
        bottomBar = {
            NavigationBar() {
                tabItems.forEachIndexed { index, item->
                    NavigationBarItem(
                        selected = selectedItem.value == index,
                        onClick = {
                                  selectedItem.value = index
                        },
                        icon = {
                               when(item){
                                   "Home" -> Icon(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = item)
                                   "Product" -> Icon(painter = painterResource(id = R.drawable.baseline_emoji_nature_24), contentDescription = item)
                                   "Setting" -> Icon(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = item)
                               }
                        },
                        label = { Text(text =item) }
                    )
                }

            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {

        }
    }

}