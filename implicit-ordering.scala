// define a class that represents our rational number
class Rational(x: Int, y: Int) {
    lazy val numer: Int = x
    lazy val denom: Int = y
}

// define an implicit value that will be used as a parameter for the ordering paramater to our customer comapre method below
implicit val ordRational: Ordering[Rational] = new Ordering[Rational] {
    def compare(x: Rational, y: Rational): Int = x.numer * y.denom - y.numer * x.denom
}

// method to compare any object that returns the greater of the two
def compareAll[T](x: T, y: T)(implicit ord: Ordering[T]): T = {
    ord.max(x,y)
}

// comparing ints
compareAll(1,2)
compareAll(5,2)

//comparing instances of rational types 
val r1 = new Rational(1,2)
val r2 = new Rational(1,4)
val r = compareAll(r1,r2); println(r.numer + "/" + r.denom)
