package yaol

import org.scalatest._
import yaol.algorithm._

class StochasticHillClimbingSpec extends FlatSpec with Matchers {

  val maxIteration = 100
  val positivesBits = 64

  "A Stochastic Hill Climbing search " should "return a number close to the positives bits" in {
    val o = StochasticHillClimbing.search(positivesBits, maxIteration)
    o.cost should be > (positivesBits - 10.0)
  }
  it should "return the positivesBits with a large maxIteration" in {
    val o = StochasticHillClimbing.search(positivesBits, maxIteration * 10)
    o.cost should be > (positivesBits - 2.0)
  }
}
