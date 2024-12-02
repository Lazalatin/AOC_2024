import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class Day2Tests {

    @Test
    fun `Day 2 - First Riddle Example`() {
        // GIVEN
        val expected = "2"

        println("Running in: ${Paths.get("").toAbsolutePath()}")

        // WHEN
        val result = runCommand("kotlinc -script day2/day2_part1.kts day2/example.txt").trimEnd()

        // THEN
        assertEquals(expected, result)
    }

    private fun runCommand(command: String) = Runtime.getRuntime()
        .exec(arrayOf("/bin/sh", "-c", command))
        .inputStream.bufferedReader().readText()

}