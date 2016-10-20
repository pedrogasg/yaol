package yaol.algorithm

import yaol.function.ObjectiveFunction
import yaol.generic._
import yaol.utils._

/**
  * Created by dev on 20/10/16.
  */
object StochasticHillClimbing {

  private def vectorMutantNeighbor(vector: Array[Int]):OptimalInt = {
    val v2 = vector.clone
    val randomIndex = scala.util.Random.nextInt(vector.size)
    val mutation = if (vector(randomIndex) == 0) 1 else 0
    v2(randomIndex) = mutation
    OptimalInt(v2,ObjectiveFunction.oneMax(v2))
  }

  private def initCurrentVector(positiveBits:Int):OptimalInt = {
    val v = Utils.randomBinary(positiveBits)
    OptimalInt(v,ObjectiveFunction.oneMax(v))
  }

  private def loop(current:OptimalInt, positiveBits:Int, maxIteration:Int):OptimalInt = {
    if(maxIteration <= 0  || current.cost == positiveBits)
      current
    else{
      val n = vectorMutantNeighbor(current.vector)
      val candidate = if(n.cost >= current.cost) n else current
      loop(candidate,positiveBits,maxIteration - 1)
    }
  }
  def search(positiveBits: Int, maxIteration: Int): OptimalInt ={
    val current = initCurrentVector(positiveBits)
    loop(current,positiveBits,maxIteration)
  }
}
