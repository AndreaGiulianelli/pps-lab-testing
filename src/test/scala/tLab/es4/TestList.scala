package tLab.es4

import org.scalacheck.Prop.{exists, forAll}
import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class TestList extends Properties("Lists"){
  def genericConcatenationProp[A: Arbitrary]: Prop =
    forAll{ (xs: List[A], ys: List[A], zs: List[A]) => (xs ++ ys) ++ zs == xs ++ (ys ++ zs)}

  def genericConcatenationWithEmpty[A: Arbitrary]: Prop =
    forAll{ (xs: List[A]) => List() ++ xs == xs }

  def genericIdentityProp[A: Arbitrary]: Prop =
    forAll{ (xs: List[A]) => xs.map(identity) == xs }

  property("List concatenation is associative") =
    Prop.all(genericConcatenationProp[Int], genericConcatenationProp[String])

  property("Empty list concatenate with a list gives the list") =
    Prop.all(genericConcatenationWithEmpty[Int], genericConcatenationWithEmpty[String])

  property("Identity on list gives the list") =
    Prop.all(genericIdentityProp[Int], genericIdentityProp[String])

  property("Compose equals to two map concatenated") =
    forAll{ (xs: List[Int], f: String => Double, g: Int => String) =>  xs.map(f compose g) == xs.map(g).map(f) }

  given arbitraryPalindrome: Arbitrary[String] = Arbitrary(
    for
      p <- Gen.alphaStr;
      c <- Gen.option(Gen.alphaChar)
    yield p + c.getOrElse("") + p.reverse)
  property("Palindromes string are equal when reversed") =
    forAll{ (p: String) => p == p.reverse }
}
