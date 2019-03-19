package mayton.primes

import mayton.primes.PrimeLib.mutuallyPrime
import org.scalatest.{FlatSpec, Matchers}

class MutuallySimpleSpec extends FlatSpec with Matchers {

  "10 and 21" should "be mutually simple" in {
    mutuallyPrime(10,21)
  }

  "10 and 20" should "not be mutually simple" in {
    !mutuallyPrime(10,20)
  }

}
