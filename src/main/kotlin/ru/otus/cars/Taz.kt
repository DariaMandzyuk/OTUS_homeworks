package ru.otus.cars

/**
 * Тачка не едет
 */
object Taz : Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw IllegalStateException("Тачка без номеров")

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput
        get() = throw IllegalStateException("Приборы сняты")

    /**
     * Доступ к горловине бака
     */
    override val tankMouth: TankMouth
        get() = throw IllegalStateException("ВЗРЫВ!")

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    override fun toString(): String {
        try {
            return "Taz(plates=$plates, fuelContents=${tankMouth.getContents()})"
        } catch (e : IllegalStateException){
            return "Это уже не машина"
        }
    }
}
