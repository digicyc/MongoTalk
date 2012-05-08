package mongotalk.casbah

import com.mongodb.casbah.Imports._


case class Unicorn(name: String, dob: Date, loves: List[String], weight: Int, gender: String, vamps: Int)

class CasbahPlay {
  private val mongoConn = MongoConnection() // Just localhost which is default.
  private val coll = mongoConn("mongotalk")("unicorns")

  /**
   * Just trying to prevent uneeded duplication/typing
   * This is assuming there is only one unicorn named @name
   */
  private def getUnicorn(name: String) = 
    coll.findOne(MongoDBObject("name" -> name)).get
  
  /**
   * Get the weight of a Unicorn by their name.
   */
  def getWeight(name: String) = 
    getUnicorn(name).getAs[Double]("weight")

  /**
   * Get the list of things the Unicorn loves by their name.
   */
  def getLoves(name: String): List[String] = {
    // Implicit inside casbah to be able to turn BasicDBList to List[AnyRef]
    getUnicorn(name).as[BasicDBList]("loves").toList.map(_.toString)
  }

  /**
   * Get Unicorns that are over 700 lbs.
   */
  def getFatties: List[String] = {
    val weightQuery = "weight" $gt 700.0

    val unicorns = (for (x <- coll.find(weightQuery)) yield x).toList
    unicorns.flatMap(_.getAs[String]("name"))
  }

  /**
   * Make sure vampire field exists.
   */
  def checkVampire = {
    val vampCheck = "vampire" $exists true
    
    val unicorns = for (x <- coll.find(vampCheck)) yield x
    unicorns.size
  }

  /**
   * Add a unicorn to our MongoDB
   * TODO: Create a Unicorn Object to simplify parameter
   */
  def addUnicorn(unicorn: Unicorn) = {
    newRec = MongoDBObject.newBuilder
    newRec += "name" -> unicorn.name
    newRec += "dob" -> unicorn.dob
    newRec += "loves" -> unicorn.loves
    newRec += "weight" -> unicorn.weight
    newRec += "gender" -> unicorn.gender
    newRec += "vampires" -> unicorn.vamps

    val res = coll.find(newRec.result)
    //  If this record doesn't exist add it.
    if(res.length <= 0)
      coll += newRec.result

    nreRec.result
  } 
}
