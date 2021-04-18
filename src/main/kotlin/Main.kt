fun toPayMasterCardAndMaestro(pay: Int, previousTransfers: Int): Any {
    var toPay = when (previousTransfers) {
        in 0..7500000 -> {
            "Комиссии нет"


        }

        else -> {
            var total = payCommission(pay)
            println("$total")
        }
    }
    return toPay
}

fun payCommission(pay: Int): Any {
    var result = pay / 100 * 0.06
    result = result - 20

    return result
}


fun toPay(pay: Int, previousTransfers: Int, card: String): Any {
    var toPay = when (card) {
        "MasterCard" -> {
            var total = toPayMasterCardAndMaestro(pay, previousTransfers)
            "Вы переводите $pay , у вас карта: $card Ваша комиссия: $total"
        }
        "Maestro" -> {
            var total = toPayMasterCardAndMaestro(pay, previousTransfers)
            "Вы переводите $pay , у вас карта: $card Ваша комиссия: $total"

        }
        "Visa" -> {
            var total = minimumComission(pay)
            "Вы переводите $pay , у вас карта: $card Ваша комиссия: $total"

        }
        "Мир" -> {
            var total = minimumComission(pay)
            "Вы переводите $pay , у вас карта: $card Ваша комиссия: $total"

        }

        else -> {
            "Вы переводите: $pay у вас карта VK Pay комиссии нет"
        }
    }
    return toPay

}

fun minimumComission(pay: Int): Any {
    var total = if (pay > 3500) {
        var result = pay / 100 * 0.75
        "$result"
    } else {
        "3500"
    }
    return total
}


fun main() {
    var card = "Visa" //тип карты

    var previousTransfers = 0   //сумма прошлого платежа

    var pay = 3500 //сумма платежа в копейках

    previousTransfers = pay + previousTransfers

    var total = toPay(pay, previousTransfers, card)

    println(total)

}