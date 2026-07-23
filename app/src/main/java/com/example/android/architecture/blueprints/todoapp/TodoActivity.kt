/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

private const val INOVA_PREFS = "inova_prefs"
private const val KEY_STORY_SHOWN = "story_shown"

/**
 * Main activity for the todoapp
 */
@AndroidEntryPoint
class TodoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Show the Inova-branded splash screen while the app initializes.
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                TodoNavGraph()
                // Show the Inova welcome story, but only on the very first launch.
                InovaStoryDialog()
            }
        }
    }
}

/**
 * Alert dialog with the Inova welcome story ("zgodbica"). It is shown only on the first
 * app launch; a flag persisted in SharedPreferences prevents it from showing again.
 */
@Composable
private fun InovaStoryDialog() {
    val context = LocalContext.current
    var showDialog by remember {
        val prefs = context.getSharedPreferences(INOVA_PREFS, Context.MODE_PRIVATE)
        mutableStateOf(!prefs.getBoolean(KEY_STORY_SHOWN, false))
    }

    if (!showDialog) return

    AlertDialog(
        onDismissRequest = {
            // Keep the story on screen until the user explicitly confirms.
        },
        title = { Text(stringResource(R.string.story_dialog_title)) },
        text = { Text(stringResource(R.string.story_dialog_message)) },
        confirmButton = {
            TextButton(
                onClick = {
                    context.getSharedPreferences(INOVA_PREFS, Context.MODE_PRIVATE)
                        .edit()
                        .putBoolean(KEY_STORY_SHOWN, true)
                        .apply()
                    showDialog = false
                }
            ) {
                Text(stringResource(R.string.story_dialog_confirm))
            }
        }
    )
}
