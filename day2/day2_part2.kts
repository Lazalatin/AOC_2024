import java.io.File
import kotlin.math.abs

var result: Int = 0
val reportList = arrayListOf<List<Int>>()

File("./${args[0]}").forEachLine {
    reportList.add(it.split(" ").map { it.toInt() })
}

for (report in reportList) {
    if (report.isSafeWithProblemDampener()) result++
}

println(result)

fun List<Int>.isSafeWithProblemDampener(): Boolean {
    if (this.isSafe()) return true

    for (index in this.indices) {
        val testList = this.toMutableList()
        testList.removeAt(index)
        if (testList.isSafe()) return true
    }
    return false
}

fun List<Int>.isSafe(): Boolean {
    var isAscendingSafe = true
    var isDescendingSafe = true
    var isDistanceSafe = true

    for (index in this.indices.first..<this.indices.last) {
        isAscendingSafe = isAscendingSafe && (this[index] < this[index + 1])
        isDescendingSafe = isDescendingSafe && (this[index] > this[index + 1])
        isDistanceSafe = isDistanceSafe && (abs(this[index] - this[index + 1]) in 1..3)
    }

    return (isAscendingSafe || isDescendingSafe) && isDistanceSafe
}