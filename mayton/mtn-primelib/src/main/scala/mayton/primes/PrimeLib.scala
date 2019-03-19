package mayton.primes

import java.lang.Math.log

import scala.annotation.tailrec

object PrimeLib {

  val π = Math.PI

  val e = Math.E

  val Χcrypto = BigInt(2).pow(4096)
  val Χmersenne = BigInt(2).pow(82589933) - 1


  implicit class IntToBase(val digits: String) extends AnyVal {
    def b = BigInt(digits)
    def h = BigInt(digits,16)
    def bi = BigInt(digits,2)
  }

  def estimatePrimes(x: Double) : Double = x / log(x)

  /**
    * Euler's function
    *
    * @param x
    * @return
    */
  def φ(n: Long): Long = {
    var result = 1
    for(i <- 2L to n)
      if (gcd(i,n) == 1)
        result = result + 1

    result
  }

  def testFerma(a: BigInt, n:BigInt): Boolean = {
    ???
  }

  /**
    * Prime candidates generator
    *
    * @return
    */
  def primeCandidates() : Stream[Int] = {
    def primeCandidates(n : Int, step : Int) : Stream[Int] = {
      n #:: primeCandidates(n + step, step^0x6)
    }

    2 #:: 3 #:: primeCandidates(5, 2)
  }

  /**
    * Factorial
    *
    * @param x
    * @return
    */
  def fact(x: BigInt): BigInt = {
    if (x < 0)
      throw new IllegalArgumentException

    @tailrec def facttail(x: BigInt, accum: BigInt): BigInt =
      if (x == 0)
        accum
      else
        facttail(x - 1, accum * x)

    facttail(x, 1)
  }

  def prod(a: BigInt, b: BigInt): BigInt = {
    if (a == b) return a
    var tx = BigInt(1)
    for (i <- a to b) {
      tx = tx * i
    }
    tx
  }

  /**
    * Сочетания. Так-же известны как биноминальный коэффициент
    *
    * \binom{n}{k} = \frac{n!}{k!*(n-k)!}
    *
    * @param m
    * @param n
    * @return
    */
  def combinations(k: BigInt, n: BigInt): BigInt = {
    if (k > n || n < 1 || k < 1) throw new IllegalArgumentException
    if (k == n) return BigInt(1)
    // TODO: Refactor. Optimize
    fact(n) / ( fact(k) * fact(n - k) )
  }

  /**
    * Перестановки.
    *
    * A(m,n) = \frac{n!}{(n-k)!}
    *
    * @param m
    * @param n
    * @return
    */
  def permutations(k: BigInt, n: BigInt): BigInt = {
    if (k > n || n < 1 || k < 1) throw new IllegalArgumentException

    val ch = fact(n)
    val zn = fact(n - k)

    return ch / zn
  }

  /**
    * Наибольший общий делитель
    *
    * @param a
    * @param b
    * @return
    */
  def gcd(a: BigInt, b: BigInt): BigInt = if (b != BigInt(0)) gcd(b, a % b) else a

  def gcd(a: Long, b: Long): Long = if (b != 0) gcd(b, a % b) else a

  def gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a

  //def gcd(a: AnyVal, b: AnyVal): AnyVal = if (b != 0) gcd(b, a % b) else a

  /**
    * Наименьшее общее кратное
    *
    * @param a
    * @param b
    * @return
    */
  def lcm(a: BigInt, b: BigInt): BigInt = (a * b) / gcd(a, b)

  /**
    * Два числа взаимно простые
    *
    * @param a
    * @param b
    * @return
    */
  def mutuallyPrime(a: BigInt, b: BigInt): Boolean = gcd(a,b) == BigInt(1)

  def mutuallyPrime(a: Long, b: Long): Boolean = gcd(a,b) == 1

  def mutuallyPrime(a: Int, b: Int): Boolean = gcd(a,b) == 1


  def mutuallySimple(list : List[BigInt]) : Boolean = {
    if (list.length < 2) throw new IllegalArgumentException
    BigInt(1) == list.reduce((a,b) => gcd(a,b))
  }


}
