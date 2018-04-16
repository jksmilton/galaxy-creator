package me.jksmilton.galaxies.generators

import com.github.jpbetz.subspace.Vector3
import org.slf4j.LoggerFactory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object SpiralGenerator {

  val logger = LoggerFactory.getLogger(getClass)

  def apply(arms: Int): Seq[Vector3] = {
    logger.info(s"Creating Spiral galaxy with $arms arms")
    val randomGenerator = new Random()

    var stars = new ArrayBuffer[Vector3]()
    //Background
    stars ++= SphericalGenerator(new Vector3(0,0,0), 25f, 200, false)

    stars ++= ClusterGenerator(new Vector3(0,0,0), 2f, 3);
    val armOffset: Float = (randomGenerator.nextGaussian() * Math.PI * 2).toFloat
    for(i <- 0 until arms) {
      stars ++= arm((2 * Math.PI * i / arms).toFloat + armOffset)
    }

    stars

  }

  def arm(theta: Float): Seq[Vector3] = {
    var stars = new ArrayBuffer[Vector3]()

    for(i <- 1 to 20) {
      val r = i * 3
      val x = r * Math.cos(theta)
      val y = r * Math.sin(theta)

      stars ++= SphericalGenerator(new Vector3(x.toFloat, y.toFloat, 0), 6f, 50, true)
    }

    stars
  }


}
