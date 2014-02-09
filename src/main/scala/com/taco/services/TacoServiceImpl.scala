package com.taco.services

import com.taco.model.Taco
import scala.collection.immutable.List
import javax.inject.Named
import javax.inject.Inject
import com.taco.config.ActorSystemBean
import spray.client.pipelining._
import spray.http.HttpHeaders.Host
import spray.http.HttpRequest
import spray.httpx.SprayJsonSupport._
import com.taco.model.Taco

@Named
class TacoServiceImpl @Inject()(asb: ActorSystemBean) extends TacoService {
  import asb._ // make the implicit ActorSystem available for sendRecieve
  import asb.system.dispatcher // execution context for futures below 
  
  def getTacoList():List[Taco] = {
    val tacoBellTaco = new Taco(Some(1),"Taco Bell", "Taco Supreme", 5.50)
    val tacoBuenoTaco = new Taco(Some(2),"Taco Bueno","Bean & Cheese Taco", 4.50)
    List(tacoBellTaco,tacoBuenoTaco)
  }
  
  def getTacoById(tacoId:Long):Taco ={
     val tacoBellTaco = new Taco(Some(1),"Taco Bell", "Taco Supreme", 5.50)
     println(tacoBellTaco)
     tacoBellTaco
  }
  
  def addTaco(taco:Taco):Taco ={
    val newTaco = new Taco(Some(3), taco.vendor,taco.desc,taco.price)
    newTaco
  }

}