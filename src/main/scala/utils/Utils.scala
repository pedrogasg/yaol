/**
  * Created by Pedro on 13/10/2016.
  */
package org.yaol.utils

object Utils {
  def randomBounded(lowerBound:Double,upperBound:Double):Double =
    lowerBound + (scala.util.Random.nextDouble * (upperBound - lowerBound))

  def randomVector(lowerBound:Double,upperBound:Double, dim:Int):Array[Double] =
    Array.tabulate(dim){ _  => randomBounded(lowerBound,upperBound) }
}
