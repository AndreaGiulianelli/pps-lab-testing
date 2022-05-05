package tLab.es6

import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.jupiter.api.Assertions
import testLab.{BasicCart, BasicCatalog, BasicLogger, BasicWarehouse, Price, Product, Shopping}

class TestShoppingSteps extends ScalaDsl with EN:
    val (p1,p2) = (Product("Shoe"), Product("Hat"))
    val warehouse = new BasicWarehouse
    val catalog = new BasicCatalog(Map[Product,Price](
        p1 -> Price(78),
        p2 -> Price(34)
    ))
    val cart = new BasicCart()
    val shopping = new Shopping(warehouse, catalog, cart, new BasicLogger(">> "))

    Given("""^A shopping$""") {
        warehouse.supply(p1, 2)
        warehouse.supply(p2, 50)
    }
    When("""^I want to but something$""") {
        shopping.pick(p1,1)
    }
    Then("""^I have to pay$""") {
        Assertions.assertTrue(cart.totalCost > 0)
    }

