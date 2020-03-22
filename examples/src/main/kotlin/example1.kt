import sampler.*

import scientifik.plotly.makeFile
import java.io.File

fun my_func1(coord: DoubleArray): Double {
    return norm_distr(
        coord,
        DoubleArray(coord.size, { 1.0 }),
        DoubleArray(coord.size, { 0.0 }),
        coord.size
    ) + norm_distr(
        coord,
        DoubleArray(coord.size, { 1.0 }),
        DoubleArray(coord.size, { -3.0 }),
        coord.size
    )
}
fun main() {
    val num = 10000
    val dim = 5
    val walks = generate_random_walks(num, dim, ::my_func1)
    makeplot(walks, dim).makeFile(File("C:/Users/user/IdeaProjects/MHSampler/examples/example1.html"))
}