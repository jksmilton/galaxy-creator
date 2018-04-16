package me.jksmilton.galaxies

import org.scalatra._
import org.scalatra.scalate.ScalateSupport
import org.slf4j.LoggerFactory

class GalaxyLandingServlet extends ScalatraServlet with ScalateSupport {
  val logger = LoggerFactory.getLogger(getClass)
  get("/") {
    logger.info("Accessed index")
    contentType = "text/html"
    layoutTemplate("/WEB-INF/layouts/galaxyViewer.jade")
  }

}
