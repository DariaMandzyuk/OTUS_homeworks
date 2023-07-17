package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int
    /**
     * Уровень топлива в баке
     */
    fun getContents(): Int
}
