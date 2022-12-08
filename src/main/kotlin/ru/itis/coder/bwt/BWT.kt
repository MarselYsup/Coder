package ru.itis.coder.bwt

import ru.itis.coder.bwt.data.BWTData
import java.util.TreeSet

fun transformBWT(line: String): BWTData {
    if(line.isEmpty()) error("Input string is empty")
    val treeSet = getSortSequence(line)
    return BWTData(getResultLine(treeSet), getLineNumberInSequence(line, treeSet))
}

private fun getSortSequence(line: String): TreeSet<String> {
    val treeSet = TreeSet<String>()
    for(i in 0..line.length) {
        treeSet.add("${line.substring(i)}${line.substring(0, i)}")
    }
    return treeSet
}

private fun getResultLine(treeSet: TreeSet<String>): String =
    treeSet.map { it[it.length - 1].toString() }.reduce{result: String, symbol -> result + symbol}

private fun getLineNumberInSequence(line: String, treeSet: TreeSet<String>): Int =
    treeSet.indexOf(line) + 1