package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("HTML content here."))
  }

  def welcome = Action {
    Ok(views.html.welcome("You are welcome."))

  }

}
