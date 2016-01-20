package controllers

import play.api._
import play.api.mvc._

class Tasks extends Controller {

  def index = Action {
    Ok(views.html.tasks.index("Add a task"))
  }

  def add = Action {
    Ok(views.html.tasks.add())
  }


}
