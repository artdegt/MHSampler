package sampler

import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.pow

//import scientifik.kmath.prob.UniformDistribution


fun normDistr(coord: DoubleArray, sigma: DoubleArray, m: DoubleArray, dim: Int = coord.size): Double {
//    var t = 0.0
//    var p = 1.0
//    for (i in 0 until dim) {
//        t -= (coord[i] - m[i]).pow(2.0) / sigma[i]
//        p *= sigma[i]
//    }
//    t = exp(t / 2.0) / (2 * Math.PI).pow(dim / 2.0) / abs(p).pow(0.5)
//    return t
    var t = 1.0
    for (i in 0 until dim) {
        t *= NormalDistribution(m[i], sigma[i]).probability(coord[i])
    }
    return t
}

fun cauchyDistr(coord: DoubleArray, gamma: DoubleArray, m: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t *= CauchyDistribution(m[i], gamma[i]).probability(coord[i])
    }
    return t
}

fun uniformDistr(coord: DoubleArray, left: DoubleArray, right: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t *= UniformDistribution(left[i]..right[i]).probability(coord[i])
    }
    return t
}

