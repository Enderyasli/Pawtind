package com.pawtind.android.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pawtind.android.R
import com.pawtind.android.data.local.AppDatabase
import com.pawtind.android.data.local.User
import com.pawtind.android.ui.main.adapter.MainAdapter
import com.pawtind.android.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    lateinit var navView:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupUI()
//        setupViewModel()
//        setupObserver()

         navView = findViewById<BottomNavigationView>(R.id.bottomNav_view)

        //Pass the ID's of Different destinations

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_favourites,
            R.id.navigation_profile,
            R.id.navigation_search
        ).build()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottomNav_view)
            .setupWithNavController(navController)


        try {
            val db = Room.databaseBuilder(
                this,
                AppDatabase::class.java, "user.db"
            ).build()

            val userDao = db.userDao()
            val users: List<User> = userDao.getAll()
        } catch (e: Exception) {

        }


    }
    fun setBottomNavigationVisibility(visibility: Int) {
        // get the reference of the bottomNavigationView and set the visibility.
        navView.visibility = visibility
    }

//    private fun setupUI() {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = MainAdapter(arrayListOf())
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter
//    }
//
//    private fun setupObserver() {
//        mainViewModel.getUsers().observe(this, Observer {
//            when (it.status) {
//                Status.SUCCESS -> {
//                    progressBar.visibility = View.GONE
//                    it.data?.let { users -> renderList(users) }
//                    recyclerView.visibility = View.VISIBLE
//                }
//                Status.LOADING -> {
//                    progressBar.visibility = View.VISIBLE
//                    recyclerView.visibility = View.GONE
//                }
//                Status.ERROR -> {
//                    //Handle Error
//                    progressBar.visibility = View.GONE
//                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                }
//            }
//        })
//    }


//    private fun renderList(users: List<com.pawtind.android.data.model.User>) {
//        adapter.addData(users)
//        adapter.notifyDataSetChanged()
//    }
//
//    private fun setupViewModel() {
//        mainViewModel = ViewModelProviders.of(
//            this,
//            ViewModelFactory(ApiHelper(ApiServiceImpl()))
//        ).get(MainViewModel::class.java)
//    }
}
