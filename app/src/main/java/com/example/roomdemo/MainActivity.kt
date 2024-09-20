package com.example.roomdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomdemo.databinding.ActivityMainBinding
import com.example.roomdemo.localdb.MyDatabase
import com.example.roomdemo.localdb.UserEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var localData = ArrayList<UserEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        for (i in 0..5)
            localData.add(UserEntity(name = "abc$i", pass = "test@123$i"))

        binding.SaveData.setOnClickListener {
            localData.let { it1 -> MyDatabase.db!!.getUsersDao().setUsers(it1) }
        }

        binding.addData.setOnClickListener {
            localData.clear()

            for (i in 0..5)
                localData.add(UserEntity(name = "abc$i", pass = "test@123$i"))
            Log.e("@@@@@@", "onCreate: ${MyDatabase.db?.getUsersDao()!!.getUsers()}")
            binding.tvResult.text = MyDatabase.db?.getUsersDao()!!.getUsers().toString()
        }

    }
}