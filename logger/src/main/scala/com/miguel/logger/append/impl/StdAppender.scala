package com.miguel.logger.append.impl

import com.miguel.logger.append.Appender

class StdAppender extends Appender {
  override def append(value: Any): Unit = println(value)
}
