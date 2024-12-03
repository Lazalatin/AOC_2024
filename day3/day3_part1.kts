import java.io.File

val mulRegex = """mul\(\d+,\d+\)""".toRegex()
val numberRegex = """\d+""".toRegex()

var result: Long = 0

File("./${args[0]}").forEachLine {
    mulRegex.findAll(it).forEach { mulString ->
        result += numberRegex.findAll(mulString.value)
            .map { digit -> digit.value.toInt() }
            .reduce(Math::multiplyExact)
    }
}

println(result)
