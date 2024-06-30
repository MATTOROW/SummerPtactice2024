package ru.itis.carsrace

class Sedan() : Car() {

    var haveABS: Boolean = true

    init {
        icon = R.drawable.ic_sedan
    }

    override fun toString(): String {
        return "Sedan(brand='$brand', model='$model', " +
                "year=$year, enginePower=$enginePower, haveABS=$haveABS, id=$id)"
    }
}