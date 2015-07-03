package models.helpers

case class ListField[T](
                         data: List[Value[T]])