package connection

import com.mongodb.casbah._

object MongoFactory {
  private val MongoConnectionString = "mongodb://localhost:27017"
  private val URI = MongoClientURI(MongoConnectionString)
  private lazy val Client = MongoClient(URI)

  def getClient: MongoClient = {
    Client
  }

  def testDB: MongoDB = {
    Client("test")
  }

  def closeConnection() {
    Client.close()
  }
}
