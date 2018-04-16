package me.jksmilton.galaxies

import com.github.jpbetz.subspace.Vector3
import me.jksmilton.galaxies.generators.{ClusterGenerator, SphericalGenerator, SpiralGenerator}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.LoggerFactory

class GalaxyManagerServlet extends ScalatraServlet with JacksonJsonSupport {
  val logger = LoggerFactory.getLogger(getClass)
  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/createGalaxy") {
    logger.info("Creating new Galaxy")
    var galaxy: Seq[Vector3] = null

    try {
       galaxy = SpiralGenerator(3)
    } catch {
      case e: Exception => logger.info(e.toString())
    }
    galaxy
  }

}
