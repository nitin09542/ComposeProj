package com.example.composecomponent
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView

class HomeActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(activity).apply {
            setContent {
                Text(text = "Home Frgament")
            }
        }
    }
    }

