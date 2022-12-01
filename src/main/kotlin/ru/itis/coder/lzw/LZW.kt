package ru.itis.coder.lzw

import ru.itis.coder.util.to8bitString
import java.lang.StringBuilder

private const val DICTIONARY_SIZE = 255
private const val SEPARATOR_SIGN = ' '

fun encodeLZW(text: String, dictionary: MutableMap<String, String>): String {
    var lastNumberOfDictionary = dictionary.size
    val code = StringBuilder("")
    var input = text
    while(input.isNotEmpty()) {
        val longestPrefix = dictionary.longestPrefixOf(input)
        code.append(dictionary[longestPrefix] + SEPARATOR_SIGN)
        val lengthPrefix = longestPrefix.length
        if(lengthPrefix < input.length) {
            if(lastNumberOfDictionary + 1 > DICTIONARY_SIZE) error("Dictionary over flow")
            dictionary[input.substring(0, lengthPrefix + 1)] = lastNumberOfDictionary++.to8bitString()
        }
        input = input.substring(lengthPrefix)
    }
    return code.toString()
}

private fun Map<String, String>.longestPrefixOf(input: String): String {
    for (i in 1..input.length) {
        if(!containsKey(input.substring(0, i))) {
            if (i == 1) error("Dictionary was not full")
            return input.substring(0, i - 1)
        }
    }
    return input
}