package mongotalk.rogue.model

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record._
import net.liftweb.record.field._

class Unicorns private() extends MongoRecord[Unicorns] with MongoId[Unicorns] {
  def meta = Unicorns

  object name extends StringField(this, 80)
  object dob extends DateTimeField(this)
  object loves extends MongoListField[Unicorns, String](this)
  object weight extends DoubleField(this, 0.0)
  object vampires extends DoubleField(this, 0.0)
}

object Unicorns extends Unicorns with MongoMetaRecord[Unicorns] {
  override def collectionName = "unicorns"
}
