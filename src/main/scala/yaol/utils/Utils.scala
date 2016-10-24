/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.utils

import yaol.generic._

object Utils {
  def randomBounded(lowerBound:Double,upperBound:Double):Double =
    lowerBound + (scala.util.Random.nextDouble * (upperBound - lowerBound))

  def randomVector(lowerBound:Double,upperBound:Double, dim:Int):Array[Double] =
    Array.fill(dim)(randomBounded(lowerBound,upperBound))

  def randomBounded(bound: Bound):Double =
    bound.lower + (scala.util.Random.nextDouble * (bound.upper - bound.lower))

  def randomVector(bound:Bound, dim:Int):Array[Double] =
    Array.fill(dim)(randomBounded(bound))

  def randomBinary(dim:Int):Array[Int] =
    Array.fill(dim)(scala.util.Random.nextInt(2))

  def randomPermutation(length:Int):IndexedSeq[Int] =
    scala.util.Random.shuffle((0 to length))

  def randomWithExclusion(n:Int,x:Int):Int = {
    def loop(n:Int,r:Int,x:Int):Int =
      if (r != x) r else loop(n,scala.util.Random.nextInt(n),x)
    loop(n,scala.util.Random.nextInt(n),x)
  }

  def randomWithExclusion(n:Int,xs:Array[Int]):Int = {
    def loop(n:Int,r:Int,xs:Array[Int]):Int =
      if (xs contains r) r else loop(n,scala.util.Random.nextInt(n),xs)
    loop(n,scala.util.Random.nextInt(n),xs)
  }
}
