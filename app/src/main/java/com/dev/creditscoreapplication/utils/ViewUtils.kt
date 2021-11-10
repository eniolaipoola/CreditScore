package com.dev.creditscoreapplication.utils

import android.view.View

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 10-Nov-2021
 */
fun View.hide(onlyInvisible: Boolean = false) {
    this.visibility = if (onlyInvisible) View.INVISIBLE else View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}
