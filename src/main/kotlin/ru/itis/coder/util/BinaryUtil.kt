package ru.itis.coder.util

fun Int.to8bitString(): String =
    Integer.toBinaryString(this).padStart(Byte.SIZE_BITS, '0')