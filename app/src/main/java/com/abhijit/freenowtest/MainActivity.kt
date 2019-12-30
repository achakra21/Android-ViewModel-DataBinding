package com.abhijit.freenowtest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.abhijit.freenowtest.databinding.ActivityMainBinding
import com.abhijit.freenowtest.databinding.ContentMainBinding
import com.abhijit.viewmodel.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

   lateinit var mainActivityViewModel:MainActivityViewModel

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        //associate viewmodel in activity
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.mainActivityViewModel = mainActivityViewModel
        binding.lifecycleOwner = this

        btnIncrement.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.scoreTeamA = mainActivityViewModel.scoreTeamA+1
            binding.invalidateAll()
        })

        btnDecrement.setOnClickListener(View.OnClickListener {
            mainActivityViewModel.scoreTeamA = mainActivityViewModel.scoreTeamA-1
            binding.invalidateAll()
        })



        //button click listener





        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
