import sampler.*

import scientifik.plotly.makeFile

fun my_func3(coord: DoubleArray): Double {
    return cauchy_distr(coord,
        DoubleArray(coord.size, { 1.0 }),
        DoubleArray(coord.size, { 2.0 }),
        coord.size)
}
fun main() {
    val num = 20000
    val dim = 1
    val walks = generate_random_walks(num, dim, ::my_func3)
    makeplot(walks, dim).makeFile(java.io.File("C:/Users/user/IdeaProjects/MHSampler/examples/example3.html"))
}