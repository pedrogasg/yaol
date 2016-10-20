package yaol

import org.scalatest._
import yaol.algorithm._
import yaol.generic._

class RandomSearchSpec extends FlatSpec with Matchers {

  val dimensions = 3
  val upperBound = 5.12
  val lowerBound = -5.12
  val maxIteration = 10000

  "A random search" should "always cost less that the upperBound" in {
    val s = RandomSearch.search(Bound(lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be < upperBound
  }
  it should "always cost more that the lowerBound" in {
    val s = RandomSearch.search(Bound(lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be > lowerBound
  }
  it should "have a value with the same lenght that the dimensions" in {
    val s = RandomSearch.search(Bound(lowerBound,upperBound),dimensions, maxIteration)
    s.vector should have length dimensions
  }
  it should "have a cost lesser that one" in {
    val s = RandomSearch.search(Bound(lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be < 1.0
  }

}
