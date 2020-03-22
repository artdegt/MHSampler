package sampler

import kotlin.math.pow

fun norm_distr(coord: DoubleArray, sigma: DoubleArray, m: DoubleArray, dim: Int = coord.size): Double {
    var t = 0.0
    var p = 1.0
    for (i in 0 until dim) {
        t -= (coord[i] - m[i]).pow(2.0) / sigma[i]
        p *= sigma[i]
    }
    t = Math.exp(t / 2.0) / (2 * Math.PI).pow(dim / 2.0) / Math.abs(p).pow(0.5)
    return t
}

fun cauchy_distr(coord: DoubleArray, gamma: DoubleArray, m: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t *= gamma[i] / ((coord[i] - m[i]).pow(2.0) + gamma[i].pow(2.0))
    }
    t /= (Math.PI).pow(dim)
    return t
}

fun uniform_distr(coord: DoubleArray, left: DoubleArray, right: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t /= (right[i] - left[i])
    }
    t = Math.abs(t)
    for (i in 0 until dim) {
        if (coord[i] < left[i] || coord[i] > right[i]) {
            return 0.0
        }
    }
    return t
}