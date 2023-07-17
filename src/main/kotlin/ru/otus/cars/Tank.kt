package ru.otus.cars

import kotlin.random.Random

interface Tankable {
    val tankMouth: TankMouth
    fun getContents(): Int
    fun receiveFuel(liters: Int)
}

class Tank(override val tankMouth: TankMouth) : Tankable {

    private val maxFuelLevel = 35

    private var fuelLevel = Random.nextInt(0, maxFuelLevel)
    override fun getContents(): Int { return fuelLevel }
    override fun receiveFuel(liters: Int) {
        if (fuelLevel + liters > maxFuelLevel)
            throw IllegalArgumentException("В бак столько не влезет!")
        fuelLevel += liters
        println("Уровень топлива теперь $fuelLevel")
    }
}
