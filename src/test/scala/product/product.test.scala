/**
  * Created by Pedro on 09/10/2016.
  */
package com.ecomm.product

import org.scalatest._

class ProducSpec extends FlatSpec with Matchers {
  def fixture = {
    new {
      val name = "Test"
      val description = "Test description"
    }
  }
  "A Product" should "have a Name" in {
    val f = fixture
    val p = Product(f.name)
    p.name shouldBe f.name
  }
  it should "have a description  if a description is provided" in {
    val f = fixture
    val p = Product(f.name, f.description)
    p.description shouldBe f.description
  }
  it should "have an empty string as description if not" in {
    val f = fixture
    val p = Product(f.name)
    p.description shouldBe empty
  }
}
