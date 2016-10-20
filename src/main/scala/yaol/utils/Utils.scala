/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.utils

import yaol.generic.Bound

object Utils {
  def randomBounded(lowerBound:Double,upperBound:Double):Double =
    lowerBound + (scala.util.Random.nextDouble * (upperBound - lowerBound))

  def randomVector(lowerBound:Double,upperBound:Double, dim:Int):Array[Double] =
    Array.tabulate(dim){ _  => randomBounded(lowerBound,upperBound) }

  def randomBounded(bound: Bound):Double =
    bound.lower + (scala.util.Random.nextDouble * (bound.upper - bound.lower))

  def randomVector(bound:Bound, dim:Int):Array[Double] =
    Array.tabulate(dim){ _  => randomBounded(bound) }

  def randomBinary(dim:Int):Array[Int] =
    Array.tabulate(dim){ _ => scala.util.Random.nextInt(2) }


}
