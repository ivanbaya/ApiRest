package com.example.apirest

import RestApiService
import UserInfo
import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById(R.id.button) as Button
        val updateButton = findViewById(R.id.buttonUpdate) as Button
        val deleteButton = findViewById(R.id.buttonDelete) as Button
        val getButton = findViewById(R.id.buttonGet) as Button
        val getNota = findViewById(R.id.buttonGetNota) as Button

        val editTextNom = findViewById(R.id.editTextId) as EditText
        val editTextId = findViewById(R.id.editTextNom) as EditText
        val editTextIdDelete = findViewById(R.id.editTextIdDelete) as EditText
        val editTextIdCicle = findViewById(R.id.editTextIdCicle) as EditText

        addButton.setOnClickListener {
            addDefaultUser()
        }
        updateButton.setOnClickListener {
            updateUser(editTextId.text.toString(), editTextNom.text.toString())
        }
        deleteButton.setOnClickListener {
            deleteUser(editTextIdDelete.text.toString())
        }
        getButton.setOnClickListener {
            getCicle(editTextIdCicle.text.toString())
        }
        getNota.setOnClickListener {
            getNota()
        }
    }
    fun addDefaultUser() {
        val apiService = RestApiService()
        val userInfo = UserInfo(  id = null,
            nom = "Nom")

        apiService.addUser(userInfo) {
            if (it?.id != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
            }
        }
    }

    fun updateUser(nom: String?, id: String) {
        val apiService = RestApiService()
        val user = UserInfo(id, nom)
        apiService.updateUser(id, user)
    }
    fun deleteUser(id: String) {
        val apiService = RestApiService()
        apiService.deleteUser(id)
    }
    fun getCicle(id: String) {
        val apiService = RestApiService()
        apiService.getCicle(id)
    }
    fun getNota(){
        val apiService = RestApiService()
        apiService.getNota();
    }
}