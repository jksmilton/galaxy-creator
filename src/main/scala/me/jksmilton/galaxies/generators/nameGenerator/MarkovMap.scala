package me.jksmilton.galaxies.generators.nameGenerator

import scala.collection.mutable

class MarkovMap[T](depth: Int) extends mutable.HashMap[T, FrequencyMap[T]] {
  val defaultDepth: Int = 1
  var _depth: Int = depth
  def Depth :Int = _depth

  def this() = this(defaultDepth)

  

}
