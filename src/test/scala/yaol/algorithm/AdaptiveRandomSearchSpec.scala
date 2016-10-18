package yaol.algorithm

import org.scalatest._

class AdaptiveRandomSearchSpec extends FlatSpec with Matchers {

  val dimensions = 3
  val smallFactor = 1.3
  val largeFactor = 5.0
  val maxIteration = 10000

  "A adaptive random search step" should "return the small factor times the step size when the iteration is zero" in {
    val zero = 0
  }
}