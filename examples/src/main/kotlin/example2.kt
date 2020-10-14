import sampler.*

//import scientifik.plotly.makeFile

fun myFunc2(coord: DoubleArray): Double {
    return uniformDistr(coord,
        DoubleArray(coord.size) { -2.0 },
        DoubleArray(coord.size) { 2.0 },
        coord.size)
}
fun main() {
    val num = 30000
    val dim = 7
    val initialCoord = DoubleArray(dim) {-1.0}
    val step = 0.2
    val pathFile = "C:/Users/user/IdeaProjects/MHSampler/examples/example2.html"
    sample(num, dim, ::myFunc2, pathFile, initialCoord, step)
}