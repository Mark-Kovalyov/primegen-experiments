package mayton.primes

import org.scalatest.{FlatSpec, Matchers}
import mayton.primes.PrimeLib._

class PermutationSpec extends FlatSpec with Matchers {

  it should "throw IllegalArgumentException any argument is negative" in {
    a [IllegalArgumentException] should be thrownBy {
      permutations(BigInt(-1),BigInt(0))
    }
    a [IllegalArgumentException] should be thrownBy {
      permutations(BigInt(0),BigInt(-1))
    }
  }

  "permutations(1,3)" should "be equals to 3" in {
    permutations(BigInt(1),BigInt(3)) should be (BigInt(3))
  }

  "permutations(2,3)" should "be equals to 6" in {
    permutations(BigInt(2),BigInt(3)) should be (BigInt(6))
  }





}
