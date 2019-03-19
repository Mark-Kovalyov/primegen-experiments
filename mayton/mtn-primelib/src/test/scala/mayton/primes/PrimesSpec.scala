package mayton.primes

import org.scalatest.{FlatSpec, Matchers}

class PrimesSpec extends FlatSpec with Matchers {

  "Assume that primary steam" should "be correct" in {
    PrimeLib.primeCandidates.take(6) should be equals List(2,3,5,7,11,13,17)
  }

}
