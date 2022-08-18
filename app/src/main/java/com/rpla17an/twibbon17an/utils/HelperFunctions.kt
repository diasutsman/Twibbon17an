package com.rpla17an.twibbon17an.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.camera.core.ImageProxy
import java.text.SimpleDateFormat
import java.util.*


object HelperFunctions {
    private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
    fun combineTwoImage(context: Context, topImage: Bitmap, bottomImage: Bitmap): Uri {
        val combinedBitmap = Canvas(bottomImage)
        combinedBitmap.drawBitmap(topImage, 0f, 0f, null)

        return writeBitmapToFile(context, bottomImage)
    }

    fun imageProxyToBitmap(imageProxy: ImageProxy): Bitmap {
        Log.d("imageProxyToBitmap", "${imageProxy.planes.size}")
        val buffer = imageProxy.planes[0].buffer
        buffer.rewind()
        val bytes = ByteArray(buffer.capacity())
        buffer.get(bytes)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            .copy(Bitmap.Config.ARGB_8888, true)
    }

    fun writeBitmapToFile(applicationContext: Context, bitmap: Bitmap): Uri {
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val imageUrl = MediaStore.Images.Media.insertImage(
            applicationContext.contentResolver,
            bitmap,
            name,
            "Twibbon17an"
        )
        return Uri.parse(imageUrl)
    }
}