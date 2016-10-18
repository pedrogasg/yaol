/**
  * Created by Pedro on 09/10/2016.
  */

package yaol

object Product{

  def apply(n:String): Product = new Product(n, "")
  def apply(n:String, d:String): Product = new Product(n, d)
}

class Product(val name:String, val description:String)