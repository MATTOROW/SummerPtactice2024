package ru.itis.carsrace

class Crossover() : Car() {

    var drive: Drives = Drives.FRONTWHEEL

    init {
        icon = R.drawable.ic_crossover
    }

    enum class Drives {
        FRONTWHEEL, REARWHEEL, ALLWHEEL;
    }

    override fun toString(): String {
        return "Crossover(brand='$brand', model='$model', year=$year, enginePower=$enginePower," +
                " drive=${drive.name}, id=$id)"
    }
}