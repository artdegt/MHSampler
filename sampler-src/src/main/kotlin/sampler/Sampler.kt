package sampler

import scientifik.plotly.PlotGrid
import scientifik.plotly.Plotly
import scientifik.plotly.makeFile
import scientifik.plotly.models.Type
import scientifik.plotly.trace
import java.io.File
import java.util.Random

fun newCoord(coord: DoubleArray, myFunc: (DoubleArray)->Double, step: Double): DoubleArray {
    val random = Random()
    var z = DoubleArray(coord.size) {0.0}
    for (i in z.indices) {
        z[i] = random.nextGaussian() * step + coord[i]
    }
    var r = myFunc(z) / myFunc(coord)
    if (r >= Random().nextDouble()) {return z}
    else {return coord}
}

fun generateRandomWalks(num: Int, dim: Int, initialCoord: DoubleArray, myFunc: (DoubleArray)->Double, step: Double): Array<DoubleArray> {
    var coord = initialCoord
    for (i in 0..1000) {
        coord = newCoord(coord, myFunc, step)
    }
    var points = Array(num) {DoubleArray(dim) {0.0} } // значения функции в точках
    for (i in 0 until num) {
        coord = newCoord(coord, myFunc, step)
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
fun sample(
    num: Int,
    dim: Int,
    myFunc: (DoubleArray)->Double,
    pathFile: String,
    initialCoord: DoubleArray = DoubleArray(dim) {-1.0},
    step: Double = 0.5
){
    val walks = generateRandomWalks(num, dim, initialCoord, myFunc, step)
    makePlot(walks, dim).makeFile(File(pathFile))
}