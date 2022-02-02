package com.example.exercicio_2022_01_31

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class FragmentProfile:Fragment(R.layout.fragment_profile) {

    private val profile: ImageView?
        get() = view?.findViewById(R.id.profile_image)

    //Configurações para acesso à câmera e galeria:
    private val galleryCallback = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val image = it.data?.data
            profile?.setImageURI(image)
        }
    }
    private val cameraCallback = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val data = it.data
            data?.extras?.get("data").let{ photo ->
                profile?.setImageBitmap(photo as Bitmap)
            }
        }
    }

    //Configuração para solicitação de acesso à câmera:
    private val permissionsResultCallback = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if(it){
            println("Permission has been granted by user.")
        }else{
            Toast.makeText(requireContext(),"Permission denied.",Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shareButton = view.findViewById<Button>(R.id.share_button)
        val userName = view.findViewById<TextView>(R.id.user_name)

        //Acessar a galeria do dispositivo, mediante o clique na imagem de perfil:
        fun getFromGallery(){
            val intent = Intent().apply {
                action = Intent.ACTION_PICK
                type = "image/*"
            }
            galleryCallback.launch(intent)
        }
        fun getFromCamera(){
            val permission = ContextCompat.checkSelfPermission(view.context, Manifest.permission.CAMERA)
            if(permission == PackageManager.PERMISSION_GRANTED){
                val intent = Intent().apply {
                    action = MediaStore.ACTION_IMAGE_CAPTURE
                }
                cameraCallback.launch(intent)
            }else{
                permissionsResultCallback.launch(Manifest.permission.CAMERA)
            }
        }

        //Executar o acesso aos apps externos:
        profile?.setOnClickListener {
            //getFromGallery()
            getFromCamera()
        }

        //Compartilhar o nome de perfil, por meio do clique:
        shareButton.setOnClickListener {
            val send: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,userName.text)
                type = "text/plain"
            }
            val share = Intent.createChooser(send,null)
            startActivity(share)
        }
    }
}