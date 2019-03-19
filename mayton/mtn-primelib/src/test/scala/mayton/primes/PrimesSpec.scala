package mayton.primes

import org.scalatest.{FlatSpec, Matchers}

class PrimesSpec extends FlatSpec with Matchers {

  "Assume that primary steam" should "be correct" in {
    // TODO: Fix
    PrimeLib.primeCandidates.take(50).foreach( x => println(s"$x") )
  }

}
