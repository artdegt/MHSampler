import sampler.*

import scientifik.plotly.makeFile

fun myFunc3(coord: DoubleArray): Double {
    return cauchyDistr(coord,
        DoubleArray(coord.size) { 1.0 },
        DoubleArray(coord.size) { 2.0 },
        coord.size)
}
fun main() {
    val num = 20000
    val dim = 1
    val pathFile = "C:/Users/user/IdeaProjects/MHSampler/examples/example3.html"
    sample(num, dim, ::myFunc3, pathFile)
}