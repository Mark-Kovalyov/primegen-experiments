package mayton.primes

import mayton.primes.PrimeLib._
import org.scalatest.{FlatSpec, Matchers}

class LcmSpec extends FlatSpec with Matchers {

  "LCM(3,5)" should "be equals to 15" in {
    lcm("3".b,"5".b) should be ("15".b)
  }

}
