package com.miguel.logger.append

trait Appender {
  def append(value: Any): Unit
}
