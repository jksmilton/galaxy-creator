package me.jksmilton.galaxies.generators.nameGenerator

import scala.collection.mutable

class FrequencyMap[T] extends mutable.HashMap[T, StateFrequency] {

  def merge(dict: Map[T, StateFrequency]): Int = {
    var count: Int = 0

    dict.foreach { case (key: T, sf: StateFrequency) =>
      if(this.contains(key)) {
        this(key).add(sf)
      } else {
        this += key -> sf
        count+= 1
      }
    }

    count
  }

}
