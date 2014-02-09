package com.taco.model

import spray.json.DefaultJsonProtocol

case class Taco(tacoId:Option[Long],vendor:String, desc:String, price:Double)

object TacoJsonProtocol extends DefaultJsonProtocol{
    implicit val tacoFormat = jsonFormat4(Taco)
}