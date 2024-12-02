import java.io.File
import kotlin.math.abs

var result: Int = 0
val left = arrayListOf<Int>()
val right = arrayListOf<Int>()

File("./${args[0]}").forEachLine {
    left.add(it.substringBefore(" ").toInt())
    right.add(it.substringAfterLast(" ").toInt())
}

left.sort()
right.sort()

for (i in left.indices) {
    result += abs(left[i] - right[i])
}

println(result)
