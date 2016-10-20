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

  private def walk(bound:Bound, coordinates:Array[Double], size:Double, largeSize:Double):(OptimalDouble,OptimalDouble) = {
    val v = oneStep(bound,coordinates,size)
    val largeV = oneStep(bound, coordinates, largeSize)
    (OptimalDouble(v,ObjectiveFunction.deJongObjective(v)), OptimalDouble(largeV, ObjectiveFunction.deJongObjective(largeV)))
  }

  private def initCurrentVector(bound:Bound, dim: Int, firstFactor:Double):(OptimalDouble,Double) = {
    val v = Utils.randomVector(bound,dim)
    (OptimalDouble(v,ObjectiveFunction.deJongObjective(v)),(bound.upper - bound.lower) * firstFactor)
  }

  def search(bound:Bound, dim: Int, maxIteration: Int, firstFactor:Double, smallFactor:Double, largeFactor:Double, multiple:Int, noneImprouvement:Int):OptimalDouble = {
    var count = 0
    var (current,size) = initCurrentVector(bound,dim, firstFactor)
    for(i <- 0 to maxIteration){
      val largeSize = maxStepSize(i,size,smallFactor,largeFactor,multiple)
      val (step, largeStep) = walk(bound,current.vector,size,largeSize)
      if (step.cost > current.cost && largeStep.cost > current.cost) {
        count = count + 1
        if (count >= noneImprouvement) {
          count = 0
          size = size / smallFactor
        }
      } else {
        if (step.cost >= largeStep.cost){
          current = largeStep
          size = largeSize
        }else{
          current = step
        }
        count = 0
      }
    }
    current
  }

}
