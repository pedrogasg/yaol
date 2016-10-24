package yaol.function

import yaol.generic._
import yaol.utils._

trait TSPFunction {
  def edge(indexs:(Int,Int), permutation:Array[Int]):(Int,Int) =
    (permutation(indexs._1),permutation(indexs._2))

  def pair(i:Int,l:Int):(Int,Int) =
    if(i >= l) (i,0) else (i,i+1)

  def cost(permutation:Array[Int],cities:Array[Array[Double]]):Double = {
    val l = permutation.size - 1
    (for(i <- 0 to l;
         point = edge(pair(i,l), permutation))
      yield ObjectiveFunction.euclideanSquareDistance(cities(point._1), cities(point._2))).sum
  }

  def towOptSwap(permutation:Array[Int], i:Int, k:Int):Array[Int] = {
    val (c1, c23) = permutation.splitAt(i)
    val (c2, c3) = c23.splitAt(k - i)
    c1 ++ c2.reverse ++ c3
  }

  def twoOptSwap(permutation:Array[Int]):Array[Int] = {
    val l = permutation.size + 1
    val i = scala.util.Random.nextInt(l)
    val k = Utils.randomWithExclusion(l,i)
    if (i > k) towOptSwap(permutation,k,i) else towOptSwap(permutation,i,k)
  }

  def buildCandidate(permutation:Array[Int],cities:Array[Array[Double]]):OptimalInt = {
    val v = twoOptSwap(permutation)
    OptimalInt(v,cost(v,cities))
  }

  def localSearch(best:OptimalInt,cities:Array[Array[Double]], noneImprouvement:Int):OptimalInt = {
    def loop(best:OptimalInt, count:Int):OptimalInt = {
      if(count >= noneImprouvement) best
      else {
        val candidate = buildCandidate(best.vector,cities)
        if(candidate.cost < best.cost) loop(candidate,0) else  loop(best,count + 1)
      }
    }
    loop(best,0)
  }
}
