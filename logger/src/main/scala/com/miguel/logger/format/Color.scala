package com.miguel.logger.format

type ColorBuilder = Color => Color

case class Color(red: Int = 0, green: Int = 0, blue: Int = 0)

extension (c: Color) {
    def compose(builders: ColorBuilder*): Color = {
        if (builders.length < 1) c
        else
            builders.foldLeft(c)((acc, builder) => builder(acc))
    }
}
