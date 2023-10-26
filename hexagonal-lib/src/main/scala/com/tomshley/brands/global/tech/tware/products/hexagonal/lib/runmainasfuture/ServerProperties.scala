/*
 * Copyright 2023 Tomshley LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 * @author Thomas Schena @sgoggles <https://github.com/sgoggles> | <https://gitlab.com/sgoggles>
 */

package com.tomshley.brands.global.tech.tware.products.hexagonal.lib
package runmainasfuture

sealed trait ServerPropertiesDef {
  val hostnameOption: Option[String] = None
  val portOption: Option[Int] = None
  val threadCountOption: Option[Int] = None
  val actorSystemNameOption: Option[String] = None

  lazy val hostname: String = {
    hostnameOption.fold(
      ifEmpty = ConfigKeys.SERVERS_HOSTNAME.toValue)(
      configValue => hostnameOption.get)
  }
  lazy val port: Int = {
    portOption.fold(
      ifEmpty = ConfigKeys.SERVERS_PORT.toValue.toInt)(
      configValue => portOption.get)
  }
  lazy val threadCount: Int = {
    threadCountOption.fold(
      ifEmpty = ConfigKeys.SERVERS_THREAD_COUNT.toValue.toInt)(
      configValue => threadCountOption.get)
  }
  lazy val actorSystemName: String = {
    actorSystemNameOption.fold(
      ifEmpty = ConfigKeys.SERVERS_ACTOR_SYSTEM_NAME.toValue)(
      configValue => actorSystemNameOption.get)
  }
}
final case class ServerProperties(
    hostnameOption: Option[String] = None,
    portOption: Option[Int] = None,
    threadCountOption: Option[Int] = None,
    actorSystemNameOption: Option[String] = None) extends ServerPropertiesDef {
}
