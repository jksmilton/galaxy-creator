package me.jksmilton.galaxies.generators
import com.github.jpbetz.subspace.{Vector3, Quaternion}
import org.slf4j.LoggerFactory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object SphericalGenerator {
  val logger = LoggerFactory.getLogger(getClass)
  def apply(center: Vector3, stdDev: Float, starCount: Int, doSwirl: Boolean): Seq[Vector3] = {
    logger.info(s"creating $starCount stars at $center with deviation $stdDev")
    val randomGenerator = new Random()
    var stars: ArrayBuffer[Vector3] = new ArrayBuffer[Vector3]()

    for( i <- 1 to starCount) {
      val x = randomGenerator.nextGaussian() * stdDev + center.x
      val y = randomGenerator.nextGaussian() * stdDev + center.y
      val z = randomGenerator.nextGaussian() * stdDev + center.z

      var star = new Vector3(x.toFloat, y.toFloat, z.toFloat)

      if(doSwirl) {
        star = swirl(star)
      }

      stars += star
      //logger.info(s"made star at $x, $y, $z")
    }

    stars
  }

  def swirl(star: Vector3): Vector3 = {
    val d = star.magnitude
    val angle:Float = (Math.pow(d, 0.1) * Math.PI * 10).toFloat
    star.rotate(Quaternion.forAxisAngle(Vector3(0,0,1).normalize, angle) )
  }

}
