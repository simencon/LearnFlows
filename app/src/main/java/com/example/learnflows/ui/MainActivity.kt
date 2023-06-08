package com.example.learnflows.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.example.learnflows.data.debug.RandomTeamMembers.getAnyTeamMember
import com.example.learnflows.ui.team.TeamComposition
import com.example.learnflows.ui.theme.LearnFlowsTheme
import com.example.learnflows.ui.theme.Purple40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            LearnFlowsTheme {
                val context = LocalContext.current
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                viewModel.insertTeamMember(getAnyTeamMember[(getAnyTeamMember.indices).random()])
                            },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Purple40
                                )
                            }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    content = { padding ->

                        val observerLoadingProcess by viewModel.isLoadingInProgress.observeAsState()
                        val observerIsNetworkError by viewModel.isNetworkError.observeAsState()

                        val pullRefreshState = rememberPullRefreshState(
                            refreshing = observerLoadingProcess!!,
                            onRefresh = { viewModel.syncTeam() }
                        )

                        Box(
                            Modifier
                                .pullRefresh(pullRefreshState)
                                .padding()
                        ) {
                            TeamComposition(appModel = viewModel)
                        }

                        if (observerIsNetworkError == true) {
                            Toast.makeText(context, "Network error!", Toast.LENGTH_SHORT).show()
                            viewModel.onNetworkErrorShown()
                        }
                    }
                )
            }
        }
    }
}
