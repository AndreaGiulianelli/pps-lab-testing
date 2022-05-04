package tLab.es6

import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.jupiter.api.Assertions
import testLab.Price

class TestShoppingSteps extends ScalaDsl with EN:
    val p = Price(10)

    Given("""A shopping""") { () =>

    }
    When("""I want to but something""") { () =>

    }
    Then("""I have to pay""") { () =>
        p.value == 10
    }

