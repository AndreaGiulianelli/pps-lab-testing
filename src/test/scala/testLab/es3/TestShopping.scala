package testLab.es3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import testLab.{BasicCart, BasicCatalog, BasicWarehouse, Price, Product}

class TestCart extends AnyFunSuite:
  test("A cart should be initially empty") {
    val cart = BasicCart()
    assert(cart.size == 0)
  }

class TestCatalog extends AnyFlatSpec with Matchers:
  "Two piece of a 10 dollar product" should "cost 20 dollars" in {
    BasicCatalog(Map(Product("TestProduct") -> Price(10))).priceFor(Product("TestProduct"), 2) shouldBe Price(20)
  }

class Fixture:
  val warehouse = BasicWarehouse()

def fixture = new Fixture

class TestWarehouse extends AnyFreeSpec with Matchers:
  "A Warehouse" - {
    val f = fixture
    "when empy" - {
      "should have 0 quantity for any given product" in {
        f.warehouse.get(Product("TestProduct"), 1) shouldBe (Product("TestProduct"), 0)
      }
    }
  }





