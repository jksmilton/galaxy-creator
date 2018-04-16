package me.jksmilton.galaxies.generators

import com.github.jpbetz.subspace.Vector3
import org.slf4j.LoggerFactory

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object ClusterGenerator {
  val logger = LoggerFactory.getLogger(getClass)
  val randomGenerator = new Random()

  def apply(center: Vector3, stdDev: Float, clusters: Int): Seq[Vector3] = {
    logger.info(s"creating $clusters clusters at $center with deviation $stdDev")
    var stars = new ArrayBuffer[Vector3]()
    for(i <- 1 to clusters) {
      val x = randomGenerator.nextGaussian() * stdDev + center.x
      val y = randomGenerator.nextGaussian() * stdDev + center.y
      val z = randomGenerator.nextGaussian() * stdDev + center.z

      val newStdDev = Math.random() * (stdDev * 0.5) + (stdDev * 0.5)
      stars ++= SphericalGenerator(new Vector3(x.toFloat, y.toFloat, z.toFloat), newStdDev.toFloat, 150, true)

    }
    stars
  }

}
