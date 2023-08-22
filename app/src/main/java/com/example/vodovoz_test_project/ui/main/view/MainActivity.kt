package com.example.vodovoz_test_project.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.vodovoz_test_project.R
import com.example.vodovoz_test_project.databinding.ActivityMainBinding
import com.example.vodovoz_test_project.ui.fragments.fragment_catalog.CatalogFragment
import com.example.vodovoz_test_project.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CatalogFragment())
            .commit()
    }

}
