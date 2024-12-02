import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Tests {

    @Test
    fun `Day 1 - First Riddle Example`() {
        // GIVEN
        val expected = "11"

        // WHEN
        val result = runCommand("kotlinc -script day1/day1_part1.kts day1/example.txt").trimEnd()

        // THEN
        assertEquals(expected, result)
    }

    private fun runCommand(command: String) = Runtime.getRuntime()
        .exec(arrayOf("/bin/sh", "-c", command))
        .inputStream.bufferedReader().readText()

}