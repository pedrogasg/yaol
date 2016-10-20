/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.algorithm

import yaol.generic._
import yaol.function._
import yaol.utils._

object RandomSearch {

  def search(bound: Bound, dim: Int, maxIteration: Int): OptimalDouble = {
    var best = OptimalDouble(Array(), bound.upper)
    for (i <- 0 to maxIteration) {
      val rv = Utils.randomVector(bound, dim)
      val cost = ObjectiveFunction.deJongObjective(rv)
      if (best.cost > cost)
        best = OptimalDouble(rv, cost)
    }
    best
  }

}
