package com.danjrosales.movierecyclerview.model

import java.io.Serializable

data class Movie(var id: Int, var name: String, var director: String, var type: String, var stock: Int):
    Serializable {
    constructor():
            this(0,"","","",0)
    }