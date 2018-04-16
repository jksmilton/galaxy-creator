package me.jksmilton.galaxies.model

class Vector(x: Double, y: Double, z: Double) {
  def X: Double = this.x
  def Y: Double = this.y
  def Z: Double = this.z

  override def toString: String = {
    s"$x, $y, $z"
  }

}
