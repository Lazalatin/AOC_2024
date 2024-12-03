import java.io.File

var result: Int = 0
val left = arrayListOf<Int>()
val right = arrayListOf<Int>()
val similarityHash = hashMapOf<Int, Int>()

File("./${args[0]}").forEachLine {
    left.add(it.substringBefore(" ").toInt())
    right.add(it.substringAfterLast(" ").toInt())
}

for (number in left) {
    for (i in right.indices) {
        if (right[i] == number) {
            similarityHash.increaseValueOf(number)
        }
    }
}


fun HashMap<Int, Int>.increaseValueOf(number: Int) {
    this.getOrElse(number) { this.put(number, 0) }
        .let { this[number] = this[number]!! + 1 }
}

fun HashMap<Int, Int>.calculateSimilarityScore(): Int {
    var result = 0

    for ((key, value) in this) result += key * value

    return result
}

println(similarityHash.calculateSimilarityScore())
