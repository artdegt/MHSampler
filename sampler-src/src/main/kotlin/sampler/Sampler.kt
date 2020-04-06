package sampler

import scientifik.plotly.PlotGrid
import scientifik.plotly.Plotly
import scientifik.plotly.models.Type
import scientifik.plotly.trace
import java.util.Random

fun newCoord(coord: DoubleArray, my_func: (DoubleArray)->Double): DoubleArray {
    val random = Random()
    var z = DoubleArray(coord.size) {0.0}
    for (i in z.indices) {
        z[i] = random.nextGaussian() * 0.5 + coord[i]
    }
    var r = my_func(z) / my_func(coord)
    if (r >= Random().nextDouble()) {return z}
    else {return coord}
}

fun generateRandomWalks(num: Int, dim: Int, my_func: (DoubleArray)->Double): Array<DoubleArray> {
    var coord = DoubleArray(dim) {-1.0}
    for (i in 0..1000) {
        coord = newCoord(coord, my_func)
    }
    var points = Array(num) {DoubleArray(dim) {0.0} } // значения функции в точках
    for (i in 0 until num) {
        coord = newCoord(coord, my_func)
        points[i] = coord
    }
    return points
}

fun makePlot(walks: Array<DoubleArray>, dim: Int) : PlotGrid {
    val plot = Plotly.page {
        //title = "Sample of 5D normal distribution"
        for (i in 0 until dim) {
            plot(1, 6) {
                val x = walks.map { q -> q[i] }

                trace(x) {
                    name = "Random data"
                    type = Type.histogram
                    //histnorm = HistNorm.probability
                    marker {
                        color = "rgb(0,0,255)"
                    }
                    xbins {
                        end = 10.0
                        start = -10.0
                        size = 0.1
                    }
                }
                layout {
                    title = "Graph $i"
                    xaxis { title = "Coordinate $i" }
                    yaxis { title = "f(coordinates)" }
                }
            }
        }
    }
    return plot
}