package com.sudedenizsuvar.vocaverseapplication.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sudedenizsuvar.vocaverseapplication.R

class Menu_page : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_page)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        // --> savedInstanceState kontrol edilmesini sağlar ve eğer kişi ilk defa uygulamayı açıyorsa (savedInstanceState null ise),
        // bir fragment ekleyerek bir ana sayfa (Home_page) oluşturur.
        // Ardından, navigasyon menüsünde bir öğenin seçili olduğunu işaretler.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Home_page())
                .commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }


    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Profile_page()).commit()
            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, setting_page()).commit()
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Home_page()).commit()
           // R.id.nav_about -> supportFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, AboutFragment()).commit()
            //R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    // kullanıcının cihazın geri tuşuna (back button) bastığında gerçekleşen
    // olayları kontrol eden bir yöntem olan `onBackPressed()` yöntemini içerir.
    // Bu yöntem, bir aktivite sınıfında bulunur ve kullanıcının geri tuşuna bastığında tetiklenir.
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}