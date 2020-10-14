package sampler

import scientifik.kmath.chains.Chain
import scientifik.kmath.chains.SimpleChain
import scientifik.kmath.prob.Distribution
import scientifik.kmath.prob.RandomGenerator
import scientifik.kmath.prob.UnivariateDistribution
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.pow

class NormalDistribution(val mean: Double, val sigma: Double) : UnivariateDistribution<Double> {

    override fun probability(arg: Double): Double {
        return exp(-(arg - mean).pow(2) / (2 * sigma.pow(2))) / (sigma * (2 * PI).pow(0.5))
    }

    //TODO check
    override fun sample(generator: RandomGenerator): Chain<Double> {
        return SimpleChain {
            mean + generator.nextDouble() * sigma
        }
    }

    override fun cumulative(arg: Double): Double {
        //TODO implementation via erf
        return 0.0
    }
}

fun Distribution.Companion.normal(mean: Double, sigma: Double): NormalDistribution =
    NormalDistribution(mean, sigma)