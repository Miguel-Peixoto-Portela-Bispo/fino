package com.miguel.logger.format

type FormatBuilder = StringBuilder => StringBuilder

class Formatter(builder: StringBuilder) {

    def compose(builders: FormatBuilder*): (StringBuilder, Formatter) = {
        val newBuilder =
            if (builders.length < 1) builder
            else builders.foldLeft(builder)((acc, builder) => builder(acc))
        (newBuilder, Formatter(newBuilder))
    }
}
object Formatter {
  def init(string: String) = Formatter(StringBuilder(string)) 
}

def setColor(color: Color)(builder: StringBuilder): StringBuilder = {
    val old = builder.toString()
    val colorString = s"\u001b[38;2;${color.red};${color.green};${color.blue}m"
    val resetColor = "\u001b[0m"

    builder.clear()
    builder.append(colorString)
    builder.append(old)
    builder.append(resetColor)
}
def setInfo(infos: String*)(builder: StringBuilder): StringBuilder = {
    val old = builder.toString()
    val chaindedInfos = infos.foldLeft(builder)((builder, info) => builder.append(s"[${info}]"))
    val prefix = s"${chaindedInfos}: "

    builder.clear()
    builder.append(prefix)
    builder.append(old)
}
def setBold(builder: StringBuilder): StringBuilder = {
    val old = builder.toString()
    val boldString = s"\u001b[1m"
    val resetBold = "\u001b[0m"

    builder.clear()
    builder.append(boldString)
    builder.append(old)
    builder.append(resetBold)
}
def setUnderline(builder: StringBuilder): StringBuilder = {
    val old = builder.toString()
    val boldString = s"\u001b[4m"
    val resetBold = "\u001b[0m"

    builder.clear()
    builder.append(boldString)
    builder.append(old)
    builder.append(resetBold)
}
def clear(builder: StringBuilder): StringBuilder = {
    builder.clear()
    builder
}
def setUpperCase(builder: StringBuilder): StringBuilder = {
  val old = builder.toString()

  builder.clear()
  builder.append(old.toUpperCase())
}
