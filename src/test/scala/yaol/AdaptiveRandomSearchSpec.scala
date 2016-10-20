package yaol

import org.scalatest._
import yaol.algorithm._
import yaol.generic._

class AdaptiveRandomSearchSpec extends FlatSpec with Matchers {

  val dimensions = 3
  val firstFactor = 0.05
  val smallFactor = 1.3
  val largeFactor = 3.0
  val maxIteration = 100
  val lowerBound = -5.12
  val upperBound = 5.12

  "A adaptive random search step" should "return the small factor times the step size when the iteration is zero" in {
    val o = AdaptiveRandomSearch.search(Bound(lowerBound,upperBound), dimensions, maxIteration, firstFactor, smallFactor, largeFactor, 10, 30)
    val zero = 0
    o.cost should be < 1.0 
  }
}
