package ru.otus.cars

enum class MouthState {
    OPEN, CLOSE
}

sealed class TankMouth {

    protected lateinit var tank : Tankable
    private var mouthState = MouthState.CLOSE.ordinal
    open fun open() {
        mouthState = MouthState.OPEN.ordinal
    }
    open fun close() {
        mouthState = MouthState.CLOSE.ordinal
    }
    fun getContents(): Int {
        return tank.getContents()
    }
    open fun receiveFuel(liters: Int) {
        if (mouthState != MouthState.OPEN.ordinal)
            throw IllegalStateException("Горловина бака закрыта. Откройте, чтобы заправить")
        tank.receiveFuel(liters)
    }
}

class LpgTankMouth() : TankMouth() {
    init {
        tank = Tank(this)
    }
    override fun open() {
        super.open()
        println("Горловина бака открыта для заправки газом")
    }
    override fun close() {
        super.open()
        println("Горловина бака закрыта")
    }
    override fun receiveFuel(liters: Int) {
        open()
        super.receiveFuel(liters)
        close()
        println("Было заправлено $liters кубометров газа")
    }
}

class PetrolTankMouth() : TankMouth() {
    init {
        tank = Tank(this)
    }
    override fun open() {
        super.open()
        println("Горловина бака открыта для заправки бензином")
    }
    override fun close() {
        println("Горловина бака закрыта")
    }
    override fun receiveFuel(liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
        println("Было заправлено $liters литров бензина")
    }
}
