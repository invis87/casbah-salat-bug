package DAO

import com.novus.salat.dao.SalatDAO
import connection.MongoFactory
import models.Profile 
import org.bson.types.ObjectId
import com.novus.salat.global._

object ProfileDAO extends SalatDAO[Profile, ObjectId](
  collection = MongoFactory.testDB("employments"))