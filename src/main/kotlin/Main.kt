fun main() {
    println(agoToTest(25000))
}

fun agoToTest(secAmount: Int): String {
    var text = ""
    when (secAmount) {
        in 0..60 -> text = "был(а) только что"
        in 61..60 * 60 -> text = "был(а) в сети ${secAmount / 60} ${minAgoToText(secAmount)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> text =
            "был(а) в сети ${secAmount / (60 * 60)} ${hoursAgoToText(secAmount)} назад"
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> text = "был(а) сегодня"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> text = "был(а) вчера"
        else -> text = "был(а) давно"
    }
    return text
}

fun minAgoToText(secAmount: Int): String {
    var text = ""
    if ((secAmount / 60) % 100 in 11..14) {
        text = "минут"
    } else {
        when ((secAmount / 60) % 10) {
            1 -> text = "минуту"
            in 2..4 -> text = "минуты"
            else -> text = "минут"
        }
    }
    return text
}

fun hoursAgoToText(secAmount: Int): String {
    var text = ""
    if ((secAmount / (60 * 60)) % 100 in 11..14) {
        text = "часов"
    } else {
        when ((secAmount / (60 * 60)) % 10) {
            1 -> text = "час"
            in 2..4 -> text = "часа"
            else -> text = "часов"
        }
    }
    return text
}

