package com.marcosk.orgs.extensions

import android.widget.ImageView
import coil.load
import com.marcosk.orgs.R

fun ImageView.loadImg(url: String? = null) {
    val imgLoader = ImgLoader(context).imageLoader()
    load(url, imgLoader) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.loading)
    }
}