/**
  * Created by Pedro on 17/10/2016.
  */
package org.yaol.algorithm

import org.yaol.utils._
object AdaptiveRandomSearch {
  private def step(lowerBound:Double, upperBound:Double, coordinates:Array[Double], size:Double):Array[Double] =
    for (c <- coordinates) yield Utils.randomBounded( lowerBound max (c - size), upperBound min (c + size))
}
