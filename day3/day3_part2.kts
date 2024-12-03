import java.io.File

val doRegex = """do\(\)""".toRegex()
val dontRegex = """don't\(\)""".toRegex()
val mulRegex = """mul\(\d+,\d+\)""".toRegex()
val numberRegex = """\d+""".toRegex()

typealias Position = Int

val resultMap = hashMapOf<Position, String>()

var result: Long = 0

File("./${args[0]}").forEachLine {
    doRegex.findAll(it).forEach { instruction -> resultMap[instruction.range.first] = instruction.value }
    dontRegex.findAll(it).forEach { instruction -> resultMap[instruction.range.first] = instruction.value }
    mulRegex.findAll(it).forEach { mulString ->
        resultMap[mulString.range.first] = numberRegex.findAll(mulString.value)
            .map { digit -> digit.value.toInt() }
            .reduce(Math::multiplyExact)
            .toString()
    }
    var applyMult = true
    resultMap.toSortedMap().values.forEach { entry ->
        if (doRegex.matches(entry)) {
            applyMult = true
        }
        if (dontRegex.matches(entry)) {
            applyMult = false
        }
        if (numberRegex.matches(entry) && applyMult){
            result += entry.toInt()
        }
        if (numberRegex.matches(entry) && !applyMult){
        }
    }
}

println(result)
