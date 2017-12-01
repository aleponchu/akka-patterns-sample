package com.garba.viajes.aponzini.common.providers

import akka.http.scaladsl.model.HttpResponse
import com.garba.viajes.aponzini.common.{AbstractWheatherModel, Providers, WeatherServiceProvider}

case class WundergroundMessage(model: String) extends AbstractWheatherModel

class WundergroundActor() extends WeatherServiceProvider with Providers{

  val serviceUrl = wundergroundUrl

  override def getWeatherService = defaultServiceCall(serviceUrl)

  override def transformModel(response: HttpResponse) = defaultStringResultConvertion(response)

  override def getNext() = sender()

  override def wrapInMessage(model: String) = WundergroundMessage(model)
}