import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class TasksSpec extends Specification {
  "Application" should {

    "send 200 when fetching tasks" in new WithApplication {
      route(FakeRequest(GET, "/tasks")) must beSome.which(status(_) == 200)
    }

    "render the welcome page" in new WithApplication{
      val tasksRequest = route(FakeRequest(GET, "/tasks")).get

      status(tasksRequest) must equalTo(OK)
      contentType(tasksRequest) must beSome.which(_ == "text/html")
      contentAsString(tasksRequest) must contain ("Add a task")
    }
  }
}
