package controllers

import play.api._
import play.api.mvc._
import models.Task

class Tasks extends Controller {

  def index = Action {
    Ok(views.html.tasks.index(Task.all))
  }

  def addTask = Action(parse.urlFormEncoded){
    implicit request =>
      Task.add(request.body.get("taskName").get.head)
      Redirect(routes.Tasks.index)
  }

}
