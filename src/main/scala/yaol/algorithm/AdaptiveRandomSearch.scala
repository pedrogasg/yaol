/**
  * Created by Pedro on 17/10/2016.
  */
package yaol.algorithm

import yaol.generic._
import yaol.utils._
import yaol.function._

object AdaptiveRandomSearch {

  private def step(bound:Bound, coordinates:Array[Double], size:Double):Array[Double] =
    for (c <- coordinates) yield Utils.randomBounded(bound.lower max (c + size), bound.upper min (c - size))

  private def maxStepSize(i:Int, size:Double, smallFactor:Double, largeFactor:Double,multiple:Int):Double =
    if(i > 0 && i % multiple == 0) size * largeFactor else size * smallFactor

  private def walk(bound:Bound, coordinates:Array[Double], size:Double, largeSize:Double):(Optimal,Optimal) = {
    val v = step(bound,coordinates,size)
    val largeV = step(bound, coordinates, largeSize)
    (Optimal(v,ObjectiveFunction.deJongObjective(v)), Optimal(largeV, ObjectiveFunction.deJongObjective(largeV)))
  }

  def search(bound:Bound,  dim: Int, maxIteration: Int, firstFactor:Double, smallFactor:Double, largeFactor:Double, multiple:Int, minImpouvement:Double) = ???

}
