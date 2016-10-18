/**
  * Created by Pedro on 13/10/2016.
  */
package org.yaol.algorithm

case class Optimal(val value: Array[Double], val cost: Double)

object RandomSearch {

  def search(searchBounds: (Double, Double), dim: Int, maxIteration: Int): Optimal = {
    import org.yaol.function._
    import org.yaol.utils._
    val (lowerBound, upperBound) = searchBounds
    var best = Optimal(Array(), upperBound)
    for (i <- 0 to maxIteration) {
      val rv = Utils.randomVector(lowerBound, upperBound, dim)
      val cost = ObjectiveFunction.deJongObjective(rv)
      if (best.cost > cost)
        best = Optimal(rv, cost)
    }
    best
  }
}
