package me.jksmilton.galaxies

import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class GalaxyLandingServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[GalaxyLandingServlet], "/*")

  test("GET / on GalaxyCreatorServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
