import java.io.File

val mulRegex = """mul\(\d+,\d+\)""".toRegex()
val digitRegex = """\d+""".toRegex()

var result: Int = 0

File("./${args[0]}").forEachLine {
    mulRegex.findAll(it).forEach { mulString ->
        result += digitRegex.findAll(mulString.value)
            .map { digit -> digit.value.toInt() }
            .reduce(Math::multiplyExact)
    }
}

println(result)
