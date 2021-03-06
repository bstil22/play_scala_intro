import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {

  "Application" should {
    "work from within a browser" in new WithBrowser {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("HTML content here.")
    }
    
    "/welcome should work within a browser" in new WithBrowser {

      browser.goTo("http://localhost:" + port + "/welcome")

      browser.pageSource must contain("You are welcome.")
    }

    "be able to add a task" in new WithBrowser {
      browser.goTo("http://localhost:" + port + "/tasks")

      browser.$("#taskBody").text("mow the lawn tomorrow")
      browser.$("#add").click()
      browser.pageSource must contain("mow the lawn tomorrow")
    }
  }
}
