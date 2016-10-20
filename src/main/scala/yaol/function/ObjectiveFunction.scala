/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.function

object ObjectiveFunction {

  def deJongObjective(xs: Iterable[Double]):Double =
    xs.foldLeft(0.0)((acc, x) => acc + (x * x))

  def oneMax(xs: Iterable[Int]):Int = xs.sum

  def euclideanSquareDistance(xs: Iterable[Double],ys: Iterable[Double]): Double = 
    math.sqrt((for((x,y) <- (xs zip ys)) yield math.pow(y - x, 2)).sum)
}
