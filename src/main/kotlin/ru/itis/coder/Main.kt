import ru.itis.coder.bwt.transformBWT
import ru.itis.coder.lzw.encodeLZW
import ru.itis.coder.lzw.util.getDictionaryFromFile
import java.util.Scanner

// change your path of file
const val FILE_PATH = "/Users/m.yusupov/IdeaProjects/Coder/src/main/resources/input.txt"
fun main() {
   println("Input your text: ")
   val text: String = Scanner(System.`in`).nextLine()
   val bwtData = transformBWT(text)
   val code = encodeLZW(bwtData.result, getDictionaryFromFile(FILE_PATH))
   print("Your code: $code\nNumber of sequence in BWT = ${bwtData.lineNumber}")
}

