import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beSome.which (status(_) == NOT_FOUND)
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("HTML content here.")
    }

    "render the welcome page" in new WithApplication{
      val welcomeRequest = route(FakeRequest(GET, "/welcome")).get

      status(welcomeRequest) must equalTo(OK)
      contentType(welcomeRequest) must beSome.which(_ == "text/html")
      contentAsString(welcomeRequest) must contain ("You are welcome.")
    }

    "render the about page" in new WithApplication{
      val welcomeRequest = route(FakeRequest(GET, "/about")).get

      status(welcomeRequest) must equalTo(OK)
      contentType(welcomeRequest) must beSome.which(_ == "text/html")
      contentAsString(welcomeRequest) must contain ("Stuff about us.")
    }
  }
}
