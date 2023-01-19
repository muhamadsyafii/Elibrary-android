package com.ransyadev.elibrary.data.dummy

import com.ransyadev.elibrary.R
import com.ransyadev.elibrary.data.model.Review

val reviewList = listOf(
    Review(
        id = 1,
        image = R.drawable.ic_review_one,
        review = 4.0,
        title = "Baru beli tapi sudah aku baca dua kali lho. Buku yang menyenangkan."
    ),
    Review(
        id = 2,
        image = R.drawable.ic_review_two,
        review = 4.0,
        title = "Ceritanya bagus"
    ),
    Review(
        id = 3,
        image = R.drawable.ic_review_three,
        review = 4.0,
        title = "Banyak nasehat yang bisa dipetik.."
    ),
    Review(
        id = 4,
        image = R.drawable.ic_review_four,
        review = 4.0,
        title = "Ceritanya ada yang sedikit aneh."
    ),
)
