package org.yaol
import akka.actor._

object Main {
  def main(args: Array[String]):Unit = {
    import org.yaol.algorithm._
    import org.yaol.function._
    import org.yaol.utils._

    val s = RandomSearch.search((-5.12,5.12),3, 1000)
    println(s)
  }
}