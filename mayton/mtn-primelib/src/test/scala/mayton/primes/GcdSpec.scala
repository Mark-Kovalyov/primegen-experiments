package mayton.primes

import mayton.primes.PrimeLib._
import org.scalatest.{FlatSpec, Matchers}

class GcdSpec extends FlatSpec with Matchers {

    "GCD(54,24)" should "be equals to 6" in {
      gcd("54".b,"24".b) should be ("6".b)
    }

    "GCD for various values" should "be correct" in {
      gcd("0".b, "0".b) should be ("0".b)
      gcd("1".b, "1".b) should be ("1".b)
      gcd("1".b, "2".b) should be ("1".b)
    }

}
