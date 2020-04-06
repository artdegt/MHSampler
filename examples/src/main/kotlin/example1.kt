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
    val walks = generateRandomWalks(num, dim, ::myFunc1)
    makePlot(walks, dim).makeFile(File("C:/Users/user/IdeaProjects/MHSampler/examples/example1.html"))
}