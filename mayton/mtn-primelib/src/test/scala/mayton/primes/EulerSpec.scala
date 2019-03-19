package mayton.primes

import mayton.primes.PrimeLib._
import org.scalatest.{FlatSpec, Matchers}

class EulerSpec extends FlatSpec with Matchers {

  "Euler function" should "be correct" in {
    φ(1) should be (1)
    φ(2) should be (1)
    φ(3) should be (2)
    φ(54) should be (18)
    φ(99) should be (60)


  }

}
