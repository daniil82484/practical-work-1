package com.example.practical_work_1

data class Poster2(val imageId: Int, val title:String, val text:String)

class PosterList2 {val list2 = arrayListOf(
    Poster2(R.drawable.img, "Имя героя", "Описание"),
    Poster2(R.drawable.img, "Имя героя", "Описание"),
    Poster2(R.drawable.img, "Имя героя", "Описание"),
    Poster2(R.drawable.img, "Имя героя", "Описание"),
)}
