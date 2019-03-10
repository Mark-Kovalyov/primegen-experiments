package mayton.primes

import org.scalatest.{FlatSpec, Matchers}
import mayton.primes.PrimeLib._

class FactorialSpec extends FlatSpec with Matchers {

  "Assume that factorial of 0" should "equals 1" in {
    val x = fact(BigInt(0))
    x should be (BigInt(1))
  }

  "Assume that factorial of 1" should "equals 1" in {
    val x = fact(BigInt(1))
    x should be (BigInt(1))
  }

  "Assume that factorial of 5" should "equals 120" in {
    val x = PrimeLib.fact(BigInt(5))
    x should be (BigInt(120))
  }

  it should "throw IllegalArgumentException if argument is negative" in {
    a [IllegalArgumentException] should be thrownBy {
      fact(BigInt(-1))
    }
  }



}
