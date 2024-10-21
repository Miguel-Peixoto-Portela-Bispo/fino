package com.miguel.logger

import com.miguel.logger.log.DefaultLogger

@main
def hello(): Unit = {
  DefaultLogger("Miguel").info("app started!")
}
