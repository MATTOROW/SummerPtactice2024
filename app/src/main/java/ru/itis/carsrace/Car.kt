package ru.itis.carsrace

open class Car(var brand: String = "null", var model: String = "null", var year: Int = 2000,
               var enginePower: Int = 0, var color: Int = 0, var icon: Int = R.drawable.ic_null, var id: Int = -1) {

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Car(brand='$brand', model='$model', year=$year, enginePower=$enginePower, id=$id)"
    }
}