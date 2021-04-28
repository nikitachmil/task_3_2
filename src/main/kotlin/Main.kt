fun main() {

    var card ="Maestro"   //тип карты

    var previousTransfers = 15_000  //сумма прошлого платежа в копейках

    var pay = 1_500_500 //сумма платежа в копейках

    previousTransfers = pay + previousTransfers



    var total = toPay(pay = pay ,previousTransfers = previousTransfers, card = card)

    println(total)
}

fun toPay(pay: Int, previousTransfers: Int = 0, card: String = "VK Pay"): Any {
    var toPay = when (card) {
        "MasterCard" -> {
            var total = check(pay, previousTransfers, card)
            "Вы переводите $pay , у вас карта: $card : $total"
        }
        "Maestro" -> {
            var total = check(pay, previousTransfers, card)
            "Вы переводите $pay , у вас карта: $card : $total"

        }
        "Visa" -> {
            var total = check(pay, previousTransfers, card)
            "Вы переводите $pay , у вас карта: $card : $total"

        }
        "Мир" -> {
            var total = check(pay, previousTransfers, card)
            "Вы переводите $pay , у вас карта: $card : $total"

        }

        "VK Pay" -> {
            var total = check(pay, previousTransfers, card)
            "Вы переводите $pay , у вас карта: $card : $total "

        }

        else -> {
            "Выберите карту "
        }
    }
    return toPay

}

fun check(pay: Int, previousTransfers: Int, card: String): Any {
    var sum = pay + previousTransfers
    var total =
        if (card == "MasterCard" || card == "Maestro") {
            if (sum > 15_000_001) {
                "Вы превысили суточный лимит "
            } else {
                minimumComission(pay, previousTransfers)
            }
        } else if (card == "Visa" || card == "Мир") {
            if (sum > 15_000_001) {
                "Вы превысили суточный лимит "
            } else {
                minimumComission(pay, previousTransfers)
            }
        } else if (card == "VK Pay") {
            if (sum > 1_500_000) {
                "Вы превысили суточный лимит "
            } else {
                "У вас нет комиссии "

            }
        } else {
        }
    return total
}


fun minimumComission(pay: Int, previousTransfers: Int): Any {

    var total = when (pay) {
        in 0..3500 -> {
            "Комиссия 35 Рублей"


        }
        else -> {
            var result = pay / 100 * 0.75
            "$result"
        }
    }
    return total
}


fun toPayMasterCardAndMaestro(pay: Int, previousTransfers: Int): Any {
    var total = when (pay) {
        in 0..7500000 -> {
            "Комиссии нет"


        }

        else -> {
            var total = payCommission(pay)
            "ваша комиссия $total"
        }
    }
    return total
}

fun payCommission(pay: Int): Any {
    var result = pay / 100 * 0.06
    result = result - 20

    return result
}