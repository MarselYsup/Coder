import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.itis.coder.lzw.encodeLZW

private class LZWTest {
    @Test
    fun `success encode should return encoded line`() {
        val input = "ААМЛМРЫАУА__ММ"
        val initialMap = mutableMapOf<String, String>("М" to "00000000", "_" to "00000001", "А" to "00000010",
            "Я" to "00000011", "Л" to "00000100", "Р" to "00000101", "Ы" to "00000110", "У" to "00000111")
        val expectedResult = "0000001000000010000000000000010000000000000001010000011000000010000001110000001000000001000000010000000000000000"
        assertEquals(expectedResult, encodeLZW(input,initialMap ))
    }

    @Test
    fun `dictionary not full encode should return error`() {
        val input = "ААМЛМРЫАУА__ММ"
        val initialMap = mutableMapOf<String, String>("М" to "00000000", "_" to "00000001", "А" to "00000010",
            "Я" to "00000011", "Л" to "00000100", "Р" to "00000101", "Ы" to "00000110")
        assertThrows<IllegalStateException> { encodeLZW(input,initialMap)}
    }

}