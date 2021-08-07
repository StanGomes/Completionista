package com.stansdevhouse.completionista

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.stansdevhouse.completionista.ui.CompletionistaTheme
import com.stansdevhouse.explore.ExploreScreen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompletionistaTheme {
                Scaffold {
                    ExploreScreen()
                }
            }
        }
    }

}

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@Preview
@Composable
fun CollectionScreenPreview() {
    CompletionistaTheme {
        ExploreScreen()
    }
}