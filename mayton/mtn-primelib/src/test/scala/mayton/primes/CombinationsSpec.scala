package mayton.primes

import mayton.primes.PrimeLib._
import org.scalatest.{FlatSpec, Matchers}

class CombinationsSpec extends FlatSpec with Matchers {

  it should "throw IllegalArgumentException any argument is negative" in {
    a [IllegalArgumentException] should be thrownBy {
      combinations(BigInt(-1),BigInt(0))
    }
    a [IllegalArgumentException] should be thrownBy {
      combinations(BigInt(0),BigInt(-1))
    }
  }

  "combinations(1,1)" should "be equals to 1" in {
    combinations(BigInt(1),BigInt(1)) should be (BigInt(1))
  }

  "combinations(1,2)" should "be equals to 2" in {
    combinations(BigInt(1),BigInt(2)) should be (BigInt(2))
  }

  "combinations(1,3)" should "be equals to 3" in {
    combinations(BigInt(1),BigInt(3)) should be (BigInt(3))
  }

  "combinations(2,3)" should "be equals to 3" in {
    combinations(BigInt(2),BigInt(3)) should be (BigInt(3))
  }

  "combinations(2,15)" should "be equals to 105" in {
    combinations(BigInt(2),BigInt(15)) should be (BigInt(105))
  }



}
