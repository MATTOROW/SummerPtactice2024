package ru.itis.carsrace

class Cabriolet() : Car() {

     var removableRoof: Boolean = false

    init {
        icon = R.drawable.ic_cabriolet
    }

    override fun toString(): String {
        return "Cabriolet(brand='$brand', model='$model', year=$year, enginePower=$enginePower, " +
                "removableRoof=$removableRoof, id=$id)"
    }
}