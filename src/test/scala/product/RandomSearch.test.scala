package org.yaol.test

import org.scalatest._
import org.yaol.algorithm._

class RandomSearchSpec extends FlatSpec with Matchers {

  val dimensions = 3
  val upperBound = 5.12
  val lowerBound = -5.12
  val maxIteration = 10000

  "A random search" should "always cost less that the upperBound" in {
    val s = RandomSearch.search((lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be < upperBound
  }
  it should "always cost more that the lowerBound" in {
    val s = RandomSearch.search((lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be > lowerBound
  }
  it should "have a value with the same lenght that the dimensions" in {
    val s = RandomSearch.search((lowerBound,upperBound),dimensions, maxIteration)
    s.value should have length dimensions
  }
  it should "have a cost lesser that one" in {
    val s = RandomSearch.search((lowerBound,upperBound),dimensions, maxIteration)
    s.cost should be < 1.0
  }

}