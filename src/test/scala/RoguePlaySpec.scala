import org.specs2.mutable._

import mongotalk.rogue.RoguePlay

class RoguePlaySpec extends Specification {
  private val roguePlay = new RoguePlay

  "The Rogue Unicorn Aurora" should {
    "weight 450 lbs" in {
      val weight = roguePlay.getWeight("Aurora")
      weight mustEqual 450.0
    }
    "love carrots" in {
      val loves = roguePlay.getLoves("Aurora")
      loves must contain("carrot")
    }
  }

  "When asking who likes apples we" should {
    "get Pilot out of the list of names" in {
      val names = roguePlay.lovesApples
      names must contain("Pilot")
    }
  }

  "When adding loves to Aurora's list we" should {
    "get the same items back" in {
      val loves = 
        roguePlay.updateLoves(List("apple", "rainbow"), "Aurora")
      loves must contain("apple", "rainbow")
    }
  }
}
