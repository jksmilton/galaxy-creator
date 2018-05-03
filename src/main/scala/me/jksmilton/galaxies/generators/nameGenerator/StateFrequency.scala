package me.jksmilton.galaxies.generators.nameGenerator

import java.util.Objects

class StateFrequency {
  private var _firstCount: Int = 0
  private var _innerCount: Int = 0
  private var _lastCount: Int = 0

  def FirstCount= _firstCount
  def InnerCount = _innerCount
  def LastCount = _lastCount

  def incrementFirst(count: Int): Unit = {
    _firstCount += count
  }
  def incrementInner(count: Int): Unit = {
    _innerCount += count
  }
  def incrementLast(count: Int): Unit = {
    _lastCount += count
  }

  def increment(count: Int): Unit = {
    incrementFirst(count)
    incrementInner(count)
    incrementLast(count)
  }

  def increment(): Unit = {
    increment(1)
  }

  def add(other: StateFrequency): Unit = {
    incrementFirst(other.FirstCount)
    incrementInner(other.InnerCount)
    incrementLast(other.LastCount)
  }

  def getValue(position: Int): Int = {
    position match {
      case Position.FIRST => _firstCount
      case Position.INNER => _innerCount
      case Position.LAST => _lastCount
      case _ => throw new Exception("Invalid position value")
    }
  }

  override def equals(obj: scala.Any): Boolean = obj match {
    case sf: StateFrequency => sf != null && sf.FirstCount.equals(_firstCount) &&
      sf.InnerCount.equals(_innerCount) && sf.LastCount.equals(_lastCount)
    case _ => false
  }



}
