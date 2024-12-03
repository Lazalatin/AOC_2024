import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class Day3Tests {

    @Test
    fun `Day 3 - First Riddle Example`() {
        // GIVEN
        val expected = "161"

        println("Running in: ${Paths.get("").toAbsolutePath()}")

        // WHEN
        val result = runCommand("kotlinc -script day3/day3_part1.kts day3/example_part1.txt").trimEnd()

        // THEN
        assertEquals(expected, result)
    }

    @Test
    fun `Day 3 - Second Riddle Example`() {
        // GIVEN
        val expected = "48"

        println("Running in: ${Paths.get("").toAbsolutePath()}")

        // WHEN
        val result = runCommand("kotlinc -script day3/day3_part2.kts day3/example_part2.txt").trimEnd()

        // THEN
        assertEquals(expected, result)
    }

    private fun runCommand(command: String) = Runtime.getRuntime()
        .exec(arrayOf("/bin/sh", "-c", command))
        .inputStream.bufferedReader().readText()

}