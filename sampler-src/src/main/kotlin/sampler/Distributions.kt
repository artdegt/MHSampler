package sampler

import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.pow

fun normDistr(coord: DoubleArray, sigma: DoubleArray, m: DoubleArray, dim: Int = coord.size): Double {
    var t = 0.0
    var p = 1.0
    for (i in 0 until dim) {
        t -= (coord[i] - m[i]).pow(2.0) / sigma[i]
        p *= sigma[i]
    }
    t = exp(t / 2.0) / (2 * Math.PI).pow(dim / 2.0) / abs(p).pow(0.5)
    return t
}

fun cauchyDistr(coord: DoubleArray, gamma: DoubleArray, m: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t *= gamma[i] / ((coord[i] - m[i]).pow(2.0) + gamma[i].pow(2.0))
    }
    t /= (Math.PI).pow(dim)
    return t
}

fun uniformDistr(coord: DoubleArray, left: DoubleArray, right: DoubleArray, dim: Int = coord.size) : Double{
    var t = 1.0
    for (i in 0 until dim) {
        t /= (right[i] - left[i])
    }
    t = abs(t)
    for (i in 0 until dim) {
        if (coord[i] < left[i] || coord[i] > right[i]) {
            return 0.0
        }
    }
    return t
}

