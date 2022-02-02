package com.example.exercicio_2022_01_31

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class SaveFile(val bitmap: Bitmap, val activity:Activity) {
    val fileName = "${System.currentTimeMillis()}.jpg"
    var fileOutputStream : OutputStream? = null
    var uri:Uri? = null

    private fun saveMediaToStorage(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            activity.contentResolver?.also { resolver ->
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }
                val imageURI:Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
                uri = imageURI
                fileOutputStream = imageURI?.let { resolver.openOutputStream(it)}
            }
        }
        else{
            val imagesDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val image = File(imagesDirectory,fileName)
            uri = Uri.fromFile(image)
            fileOutputStream = FileOutputStream(image)
        }

        fileOutputStream?.use{
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,it)
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM,uri)
                type = "image/jpeg"
            }
            activity.startActivity(Intent.createChooser(shareIntent,"Print"))
        }
    }
}