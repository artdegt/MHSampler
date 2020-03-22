import sampler.*

import scientifik.plotly.makeFile

fun my_func2(coord: DoubleArray): Double {
    return uniform_distr(coord,
        DoubleArray(coord.size, { -2.0 }),
        DoubleArray(coord.size, { 2.0 }),
        coord.size)
}
fun main() {
    val num = 10000
    val dim = 7
    val walks = generate_random_walks(num, dim, ::my_func2)
    makeplot(walks, dim).makeFile(java.io.File("C:/Users/user/IdeaProjects/MHSampler/examples/example2.html"))
}