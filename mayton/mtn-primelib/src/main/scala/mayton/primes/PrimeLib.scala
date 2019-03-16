package mayton.primes

import java.lang.Math.log

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

  // TODO: Improove acuaracy
  def densityPrimes(x: Int) : Int = (x / log(x)).asInstanceOf[Int]


  /**
    * Factorial
    *
    * @param x
    * @return
    */
  def fact(x: BigInt): BigInt = {
    if (x < BigInt(0)) throw new IllegalArgumentException
    var tx = BigInt(1)
    for (i <- BigInt(2) to x) {
      tx = tx * i
    }
    tx
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
  def mutuallySimple(a: BigInt, b: BigInt): Boolean = gcd(a,b) == BigInt(1)


  def mutuallySimple(list : List[BigInt]) : Boolean = {
    if (list.length < 2) throw new IllegalArgumentException
    BigInt(1) == list.reduce((a,b) => gcd(a,b))
  }


}
