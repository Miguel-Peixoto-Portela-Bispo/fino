package com.miguel.logger.log

import com.miguel.logger.append.impl.StdAppender
import com.miguel.logger.format._
import java.text.Normalizer.Form

class DefaultLogger[T](owner: Class[T] | String) {
    val ownerName = owner match {
        case c: Class[T] => c.getName()
        case s: String   => s
    }
    val appender = StdAppender()
    val formatter = Formatter.init("")

    appender.append(
      s"started a ${this.getClass().getName()} for the '${ownerName}'."
    )

    def info(value: String): Unit = {
        val (stringBuilder, _) = setLogInfo(formatter)(LogLevel.INFO)
        val toPrint = stringBuilder.append(value)

        appender.append(toPrint)
    }
    private def log(level: LogLevel)(value: String): Unit = {}
    private def setLogInfo(
        formatter: Formatter
    )(level: LogLevel): (StringBuilder, Formatter) = {
        setCustomInfo(formatter)(s"owner: ${ownerName}", s"")
    }
    private def setCustomInfo(
        formatter: Formatter
    )(infos: String*): (StringBuilder, Formatter) = {
        formatter.compose(
          setInfo(infos*),
          setUpperCase,
          setBold
        )
    }
}
