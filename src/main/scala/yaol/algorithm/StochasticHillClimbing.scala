package yaol.algorithm

import yaol.function.ObjectiveFunction
import yaol.generic.{Bound, OptimalInt}
import yaol.utils.Utils

/**
  * Created by dev on 20/10/16.
  */
object StochasticHillClimbing {

  private def vectorMutation(vector: Array[Int]) = {
    val v2 = vector.clone
    val randomIndex = scala.util.Random.nextInt(vector.size)
    val mutation = if (vector(randomIndex) == 0) 1 else 0
    v2(randomIndex) = mutation
    v2
  }

  private def initCurrentVector(positiveBits:Int):OptimalInt = {
    val v = Utils.randomBinary(positiveBits)
    OptimalInt(v,ObjectiveFunction.oneMax(v))
  }

  def search(positiveBits: Int, maxIteration: Int): Unit ={
    val current = initCurrentVector(positiveBits)

  }
}
