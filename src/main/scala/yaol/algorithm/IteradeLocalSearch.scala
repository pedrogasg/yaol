/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.algorithm

import yaol.function._

object IteradeLocalSearch {

  private def edge(indexs:(Int,Int), permutation:Array[Int]):(Int,Int) =
    (permutation(indexs._1),permutation(indexs._2))

  private def pair(i:Int,l:Int):(Int,Int) = 
    if(i >= l) (i,0) else (i,i+1)

  private def cots(permutation:Array[Int],cities:Array[Array[Double]]):Double = {
    val l = permutation.size - 1
   (for(i <- 0 to l;
     point = edge(pair(i,l), permutation))
   yield ObjectiveFunction.euclideanSquareDistance(cities(point._1), cities(point._2))).sum
  }

  def search(): Unit = {
  }

}

