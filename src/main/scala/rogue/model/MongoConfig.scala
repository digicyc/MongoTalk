package mongotalk.rogue.model

import net.liftweb.mongodb._
import com.mongodb.{ServerAddress, Mongo}

object AdminDb extends MongoIdentifier {
  val jndiName = "admin"
}

object MongoConfig {
  def mUser = "testuser"
  def mPass = "testpass"

  def init: Unit = {
    val srvr = new ServerAddress("127.0.0.1", 27017)
    
    MongoDB.defineDb(DefaultMongoIdentifier, new Mongo(srvr), "mongotalk")
    MongoDB.defineDb(AdminDb, new Mongo(srvr), "admin")
  }
}
