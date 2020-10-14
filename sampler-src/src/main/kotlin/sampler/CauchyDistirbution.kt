package sampler

import scientifik.kmath.chains.Chain
import scientifik.kmath.chains.SimpleChain
import scientifik.kmath.prob.Distribution
import scientifik.kmath.prob.RandomGenerator
import scientifik.kmath.prob.UnivariateDistribution
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.atan

class CauchyDistribution(val shift: Double, val scale: Double) : UnivariateDistribution<Double> {

    override fun probability(arg: Double): Double {
        return scale / (PI * ((arg - shift).pow(2) + scale.pow(2)))
    }

    //TODO check
    override fun sample(generator: RandomGenerator): Chain<Double> {
        return SimpleChain {
            shift + generator.nextDouble() * scale
        }
    }

    override fun cumulative(arg: Double): Double {
        return atan((arg - shift) / scale) / PI + 0.5
    }
}

fun Distribution.Companion.cauchy(shift: Double, scale: Double): CauchyDistribution =
    CauchyDistribution(shift, scale)