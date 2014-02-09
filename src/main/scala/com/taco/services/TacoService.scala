package com.taco.services

import scala.collection.immutable.List
import com.taco.model.Taco


trait TacoService {
  def getTacoList():List[Taco]
  def getTacoById(tacoId:Long):Taco
  def addTaco(taco:Taco):Taco
}