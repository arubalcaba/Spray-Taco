package com.taco.actors.routes

import spray.routing.HttpServiceActor
import javax.inject.Inject
import com.taco.config.ActorSystemBean
import akka.actor.ActorLogging
import com.taco.services.TacoService
import javax.inject.Named
import org.springframework.context.annotation.Scope
import com.taco.model.TacoJsonProtocol._
import spray.httpx.SprayJsonSupport._
import com.taco.model.Taco
import spray.http.StatusCodes


@Named
@Scope("prototype")
class TacoActor  @Inject()(tacoService: TacoService, asb: ActorSystemBean) extends HttpServiceActor 
																	with ActorLogging {
   import asb.system.dispatcher
   
   def receive = runRoute {
     get {
        pathEnd {
           val tacoList = tacoService.getTacoList
           tacoList match{
             case head::tail => complete(tacoList)
             case nil => complete(StatusCodes.NoContent)
             
           }
            complete(tacoList)
          }~
          path(LongNumber){tacoId =>
            val taco = tacoService.getTacoById(tacoId)
            complete(taco)
          }
     }~
     post {
    	 pathEnd {
	        entity(as[Taco]) { taco =>
	          val newTaco = tacoService.addTaco(taco)
	          complete(newTaco)
        }
      }
    }~
     put{
        path(LongNumber){tacoId =>
           complete(StatusCodes.NoContent)
        }
      }~
     delete{
        path(LongNumber){tacoId =>
           complete(StatusCodes.NoContent)
        }
      } 
   }
   

}