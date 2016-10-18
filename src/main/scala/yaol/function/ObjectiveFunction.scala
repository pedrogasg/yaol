/**
  * Created by Pedro on 13/10/2016.
  */
package yaol.function

object ObjectiveFunction {
  def deJongObjective(xs: Iterable[Double]):Double =
    xs.foldLeft(0.0)((acc, x) => acc + (x * x))
}
