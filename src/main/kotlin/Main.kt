import java.text.DecimalFormat
import kotlin.math.absoluteValue
import kotlin.math.pow

// ref: https://www.desmos.com/calculator/2kkw81jkqu
fun Double.format(): String = DecimalFormat("0.000").format(this)
fun proportion(x: Double) = x
fun square(x: Double) = x.pow(2).div(42 - 1)
fun inverseProportion(x: Double) = (-1 - 42.0.div(x - 42.0)).absoluteValue

fun main() {
    listOf(
        (1..6).map { it.times(7).toDouble() },
        listOf(0.0, 0.5, 1.0, 10.0, 21.0, 41.0, 41.5, 41.9, 41.99, 41.999, 42.0)
    ).forEach { listOfX ->
        listOf(::proportion, ::square, ::inverseProportion).forEach { function ->
            println(function.name)
            listOfX.forEach { x ->
                val y = function.call(x)
                print("[${x.format()}, ${y.format().padStart(6)}], ")
            }
            println()
        }
        println()
    }
}