package yaol

import org.scalatest._
import yaol.algorithm._
import yaol.generic._

class AdaptiveRandomSearchSpec extends FlatSpec with Matchers {

  val dimensions = 3
  val smallFactor = 1.3
  val largeFactor = 5.0
  val maxIteration = 10000

  "A adaptive random search step" should "return the small factor times the step size when the iteration is zero" in {
    val o = AdaptiveRandomSearch.search(Bound(-5.12,5.12), 2, 100, 0.05, 1.3, 3.0, 10, 30)
    val zero = 0
    o.cost should be < 1.0 
  }
}
