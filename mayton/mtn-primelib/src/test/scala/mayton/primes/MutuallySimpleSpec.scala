package mayton.primes

import mayton.primes.PrimeLib.mutuallySimple
import org.scalatest.{FlatSpec, Matchers}

class MutuallySimpleSpec extends FlatSpec with Matchers {

  "10 and 21" should "be mutually simple" in {
    mutuallySimple(10,21)
  }

  "10 and 20" should "not be mutually simple" in {
    !mutuallySimple(10,20)
  }

}
