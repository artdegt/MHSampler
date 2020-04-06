import sampler.*

import scientifik.plotly.makeFile

fun myFunc2(coord: DoubleArray): Double {
    return uniformDistr(coord,
        DoubleArray(coord.size) { -2.0 },
        DoubleArray(coord.size) { 2.0 },
        coord.size)
}
fun main() {
    val num = 10000
    val dim = 7
    val walks = generateRandomWalks(num, dim, ::myFunc2)
    makePlot(walks, dim).makeFile(java.io.File("C:/Users/user/IdeaProjects/MHSampler/examples/example2.html"))
}