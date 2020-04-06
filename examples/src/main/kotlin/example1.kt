import sampler.*

import scientifik.plotly.makeFile
import java.io.File

fun myFunc1(coord: DoubleArray): Double {
    return normDistr(
        coord,
        DoubleArray(coord.size) { 1.0 },
        DoubleArray(coord.size) { 0.0 },
        coord.size
    ) + normDistr(
        coord,
        DoubleArray(coord.size) { 1.0 },
        DoubleArray(coord.size) { -3.0 },
        coord.size
    )
}
fun main() {
    val num = 10000
    val dim = 5
    val initialCoord = DoubleArray(dim) {-1.0}
    val step = 1.0
    val pathFile = "C:/Users/user/IdeaProjects/MHSampler/examples/example1.html"
    sample(num, dim, ::myFunc1, pathFile, initialCoord, step)
}