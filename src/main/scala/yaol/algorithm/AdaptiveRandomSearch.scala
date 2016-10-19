/**
  * Created by Pedro on 17/10/2016.
  */
package yaol.algorithm

import yaol.generic._
import yaol.utils._
import yaol.function._

object AdaptiveRandomSearch {

  private def oneStep(bound:Bound, coordinates:Array[Double], size:Double):Array[Double] =
    for (c <- coordinates) yield Utils.randomBounded(bound.lower max (c + size), bound.upper min (c - size))

  private def maxStepSize(i:Int, size:Double, smallFactor:Double, largeFactor:Double,multiple:Int):Double =
    if(i > 0 && i % multiple == 0) size * largeFactor else size * smallFactor

  private def walk(bound:Bound, coordinates:Array[Double], size:Double, largeSize:Double):(Optimal,Optimal) = {
    val v = oneStep(bound,coordinates,size)
    val largeV = oneStep(bound, coordinates, largeSize)
    (Optimal(v,ObjectiveFunction.deJongObjective(v)), Optimal(largeV, ObjectiveFunction.deJongObjective(largeV)))
  }

  def search(bound:Bound,  dim: Int, maxIteration: Int, firstFactor:Double, smallFactor:Double, largeFactor:Double, multiple:Int, noneImpouvement:Int):Optimal = {
    val v = Utils.randomVector(bound,dim)
    var count = 0
    var size = (bound.upper - bound.lower) * firstFactor
    var current = Optimal(v,ObjectiveFunction.deJongObjective(v))
    for(i <- maxIteration){
      val largeSize = maxStepSize(i,size,smallFactor,largeFactor,multiple)
      val (step, largeStep) = walk(bound,current.vector,size,largeSize)
      if( step.cost <= current.cost || largeStep.cost <= current.cost) {
        if (step.cost >= largeStep.cost) {
          current = largeStep
          size = largeSize
        } else current = step
        count = 0
      } else{
        count =  count + 1
        if(count >= noneImpouvement){
          count = 0
          size = size / smallFactor
        }
      }

    }
    current
  }

}
