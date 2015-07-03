package models.helpers

import org.joda.time.Instant

case class Value[T](
                     value: T,
                     //Exception in thread "main" java.lang.IllegalArgumentException: can't serialize class org.joda.time.Instant
                     //So I change it to String
                     retrieved: Option[String] //Option[Instant]
                     )