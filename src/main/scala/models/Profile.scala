package models

import models.helpers.ListField

case class Profile(
                    name: String,
                    employment: Option[ListField[Employment]])
