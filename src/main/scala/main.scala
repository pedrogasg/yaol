package yaol
import akka.actor._

object Main {
  def main(args: Array[String]):Unit = {
    import yaol.algorithm._
    import yaol.function._
    import yaol.utils._
    import yaol.generic._

    val s = RandomSearch.search(Bound(-5.12,5.12),3, 1000)
    println(s)
  }
}