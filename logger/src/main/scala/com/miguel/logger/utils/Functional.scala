package com.miguel.logger.utils

def compose[T](functions: T => T*)(value: T) = {
    if (functions.length < 1) value
    else functions.foldLeft(value)((value, function) => function(value))
}
