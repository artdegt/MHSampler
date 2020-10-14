import sampler.*

import scientifik.plotly.makeFile
import java.io.File
import scientifik.kmath.prob.UniformDistribution

fun newDistr(): Unit {
    println(UniformDistribution(0.0..1.0).probability(0.5))
}

fun main() {
    newDistr()
}