import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.itis.coder.bwt.data.BWTData
import ru.itis.coder.bwt.transformBWT

private class BWTTest {
    @Test
    fun `success transform should return BWTData`() {
        val input = "МАМА_МЫЛА_РАМУ"
        val expectedResult = BWTData("ААМЛМРЫАУА__ММ", 9)
        assertEquals(expectedResult, transformBWT(input))
    }
    @Test
    fun `empty line transform should return error`() {
        val input = ""
        assertThrows<IllegalStateException> {  transformBWT(input) }
    }
    @Test
    fun `success transform with length 1 should return BWTData`() {
        val input = "А"
        val expectedResult = BWTData("А", 1)
        assertEquals(expectedResult, transformBWT(input))
    }
}