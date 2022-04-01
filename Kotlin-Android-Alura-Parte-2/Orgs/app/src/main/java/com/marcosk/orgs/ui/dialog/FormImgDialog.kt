package com.marcosk.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.marcosk.orgs.databinding.ActivityFormImgBinding
import com.marcosk.orgs.extensions.loadImg

class FormImgDialog (private val context: Context) {

    fun show(
        urlDefault: String? = null,
        whenImgLoad: (img: String) -> Unit
    ){
        ActivityFormImgBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlDefault?.let {
                    formImgImg.loadImg(it)
                    formImgUrl.setText(it)
                }

                formImgBtnLoad.setOnClickListener{
                    val url = formImgUrl.text.toString()
                    formImgImg.loadImg(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar"){ _, _ ->
                        val url = formImgUrl.text.toString()
                        whenImgLoad(url)
                    }
                    .setNegativeButton("Cancelar"){ _, _ ->

                    }
                    .show()

            }
    }
}