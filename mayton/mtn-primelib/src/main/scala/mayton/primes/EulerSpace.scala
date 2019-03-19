package mayton.primes

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.FileOutputStream

import javax.imageio.ImageIO

object EulerSpace {

  def main(args: Array[String]): Unit = {

    val SIZE = 512
    val PIXEL = 4

    val HACKY = "d2b21e"
    val DARKLEAVE = "17420f"

    val image = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB)

    val g2d = image.createGraphics

    for(i <- 0 to SIZE / PIXEL) {
      for(j <- 0 to SIZE / PIXEL) {
        val x : BigInt = i
        val y : BigInt = j
        g2d.setColor(if (x.isProbablePrime(10) && y.isProbablePrime(10)) Color.BLUE else Color.DARK_GRAY)
        g2d.fillRect(i * PIXEL, j * PIXEL, PIXEL, PIXEL)
      }
    }

    ImageIO.write(
      image,
      "PNG",
      new FileOutputStream(s"out/euler-space-${SIZE}x${SIZE}.png"))

  }


}
