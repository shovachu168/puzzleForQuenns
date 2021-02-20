const val SIZE = 7
val QUEEN_INFO_LIST = ArrayList<QueenInfo>()
val X_HAS_QUEEN = ArrayList<Int>()
var RESULT_CONUT = 1

class QueenInfo(x: Int, y: Int) {
    val positionX = x
    val positionY = y
}

fun main(args: Array<String>) {
    getQueensPosition()
}

fun getQueensPosition() {
    for (x in 0..SIZE) {
        QUEEN_INFO_LIST.clear()
        X_HAS_QUEEN.clear()
        X_HAS_QUEEN.add(x)
        QUEEN_INFO_LIST.add(QueenInfo(x, 0))
        placeRowQueen(1)
    }
}

fun placeRowQueen(queenYPosition: Int) {
    for (x in 0..SIZE) {
        if (X_HAS_QUEEN.subList(0, queenYPosition).contains(x)) {
            continue
        }
        val tempQueen = QueenInfo(x, queenYPosition)
        if (canPlace(tempQueen, queenYPosition)) {
            if (QUEEN_INFO_LIST.size < queenYPosition + 1) {
                QUEEN_INFO_LIST.add(tempQueen)
                X_HAS_QUEEN.add(x)
            } else {
                QUEEN_INFO_LIST[queenYPosition] = tempQueen
                X_HAS_QUEEN[queenYPosition] = x
            }
            placeRowQueen(queenYPosition + 1)
            if(queenYPosition == SIZE && QUEEN_INFO_LIST.size == 8) {
                printResult()
            }
        }
    }
}

fun canPlace(info: QueenInfo, bound: Int): Boolean {
    QUEEN_INFO_LIST.subList(0, bound).iterator().forEach {
        if (kotlin.math.abs(it.positionX - info.positionX) == kotlin.math.abs(
                it.positionY - info.positionY
            )
        ) {
            return false
        }
    }
    return true
}


fun printResult() {
    println("result $RESULT_CONUT")
    QUEEN_INFO_LIST.iterator().forEach {
        var result = arrayOf(".", ".", ".", ".", ".", ".", ".", ".")
        result[it.positionX] = "Q"
        result.iterator().forEach {answer ->
            print(answer)
        }
        println()
    }
    RESULT_CONUT++
}


