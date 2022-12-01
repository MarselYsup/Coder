package ru.itis.coder.lzw.util

import ru.itis.coder.util.to8bitString
import java.io.File

fun getDictionaryFromFile(fileName: String): MutableMap<String, String> {
    var numberOfCode = 0
    val mutableMap = mutableMapOf<String, String>()
    for(line in File(fileName).bufferedReader().readLine().split(" ")) {
        mutableMap[line] = numberOfCode++.to8bitString()
    }
    return mutableMap
}