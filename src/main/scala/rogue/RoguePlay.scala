package mongotalk.rogue

import mongotalk.rogue.model._
import com.foursquare.rogue.Rogue._

class RoguePlay {
  // Setup and connect to our MongoDB
  MongoConfig.init

  /**
   * Get the weight from specified Unicorn.
   */
  def getWeight(name: String) = {
    val unicorn =
      Unicorns where (_.name eqs name) get

    (unicorn.get).weight.is
  }

  /**
   * Get a list of 'loves' from specified Unicorn.
   */
  def getLoves(name: String): List[String] = {
    val unicorn = 
      Unicorns where (_.name eqs name) get

    (unicorn.get).loves.is
  }

  /**
   * Get a list of names of Unicorns that love Apples.
   */
  def lovesApples: List[String] = {
    val unicorns = 
      Unicorns where (_.loves contains "apple") fetch

    for {
      unicorn <- unicorns
    } yield unicorn.name.is
  }

  /**
   * Append items to the Specified Unicorn's 'loves' list.
   */
  def updateLoves(items: List[String], uni: String) = {
    val unicorn =
      Unicorns where (_.name eqs uni) modify (_.loves pushAll items)
    unicorn.updateOne()
   
    this.getLoves(uni)
  }
}
