package ir.magiccodes.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import ir.magiccodes.wikipedia.databinding.ActivityMainBinding
import ir.magiccodes.wikipedia.fragment.FragmentExplore
import ir.magiccodes.wikipedia.fragment.FragmentProfile
import ir.magiccodes.wikipedia.fragment.FragmentTrend

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        navigationDrawer()
        firstRun()
        bottomNavigation()

    }

    fun navigationDrawer(){
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolbarMain ,
            R.string.open_drawer ,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.menu_writer ->{
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val dialog = SweetAlertDialog(this , SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a Writer?"
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "you can be a writer", Toast.LENGTH_SHORT).show()
                    }
                    dialog.show()
                }

                R.id.menu_photographer ->{

                }

                R.id.menu_video_maker ->{

                }

                R.id.menu_translator ->{

                }
                //-----------------------
                R.id.menu_open_wikipedia ->{

                }

                R.id.menu_open_wikimedia ->{

                }
            }

            true
        }
    }

    fun bottomNavigation(){

        binding.bottomNavigationMain.setOnItemSelectedListener {

            when(it.itemId){
                R.id.menu_explore ->{
                    replaceFragment(FragmentExplore())
                }

                R.id.menu_trend ->{
                    replaceFragment(FragmentTrend())
                }

                R.id.menu_profile ->{
                    replaceFragment(FragmentProfile())
                }
            }
            true
        }

        binding.bottomNavigationMain.setOnItemReselectedListener {  }
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment)
        transaction.commit()
    }

    fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }


}