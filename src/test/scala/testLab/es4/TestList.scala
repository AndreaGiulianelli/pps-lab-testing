package testLab.es4

import org.scalacheck.Prop.{exists, forAll}
import org.scalacheck.{Arbitrary, Prop, Properties}

class TestList extends Properties("Lists"){
  def genericConcatenationProp[A: Arbitrary]: Prop =
    forAll{ (xs: List[A], ys: List[A], zs: List[A]) => (xs ++ ys) ++ zs == xs ++ (ys ++ zs)}

  property("List concatenation is associative") =
    Prop.all(genericConcatenationProp[Int], genericConcatenationProp[String])
}
