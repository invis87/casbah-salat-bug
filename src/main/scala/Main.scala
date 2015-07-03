import DAO.ProfileDAO
import com.mongodb.casbah.commons.MongoDBObject
import connection.MongoFactory
import models.helpers.{Value, ListField}
import models.{Profile, Employment}
import org.joda.time.Instant

object Main {

  def main(args: Array[String]) {

//    insert()

    printAllProfilesEmployments()

    MongoFactory.closeConnection()
  }

  def insert() = {

    val emp1 = Value[Employment](Employment("1", "USA", "SF"), Option("how to deserialize joda.Time.Instant?"))
    val emp2 = Value[Employment](Employment("2", "Canada", "Ottawa"), Option("how to deserialize joda.Time.Instant?"))

    val employments = ListField[Employment](List(emp1, emp2))
    val profile = Profile("Alex", Option(employments))

    ProfileDAO.insert(profile)

//    This data will be in database after:
//    { "_id" : ObjectId("5596b8afd4c67d0eff03689c"), "name" : "Alex", "employment" : { "data" : [
//      { "value" : [ "1", "USA", "SF" ], "retrieved" : "how to deserialize joda.Time.Instant?" },
//      { "value" : [ "2", "Canada", "Ottawa" ], "retrieved" : "how to deserialize joda.Time.Instant?" }
//    ] } }
  }

  def printAllProfilesEmployments() = {
    val profiles = ProfileDAO.find(MongoDBObject.empty).toList
    for(p <- profiles){
      //this works fine, but we can see that Employment in data is just a List
      println(p.toString)
    }

    for(p <- profiles){
      val employments = p.employment.get.data
      //this fails: java.lang.ClassCastException: com.mongodb.BasicDBList cannot be cast to models.Employment
      employments.foreach(emp => println(emp.value.toString))
    }
  }
}
