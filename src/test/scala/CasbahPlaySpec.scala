import org.specs2.mutable._

import mongotalk.casbah.CasbahPlay

class CasbahPlaySpec extends Specification {
  private val casbahPlay = new CasbahPlay

  "The Casbah Unicorn Aurora" should {
    "weight 450 lbs" in {
      val weight = casbahPlay.getWeight("Aurora").get
      weight mustEqual 450.0
    }
    "love carrots" in {
      val loves = casbahPlay.getLoves("Aurora")
      loves must contain("carrot")
    }
  }

  "The Casbah Unicorn Ayna" should {
    "be in list of over weight Unicorns" in {
      val fatties = casbahPlay.getFatties
      fatties must contain("Ayna")
    }
  }

  "The vampires field" should {
    "exist" in {
      casbahPlay.checkVampire must be_>=(1)
    }
  }
}
