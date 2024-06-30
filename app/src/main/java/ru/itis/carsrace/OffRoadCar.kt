package ru.itis.carsrace

class OffRoadCar(): Car() {

    var wheelSize : Int = 10

    init {
        icon = R.drawable.ic_offroad_car
    }

    override fun toString(): String {
        return "OffRoadCar(brand='$brand', model='$model', " +
                "year=$year, enginePower=$enginePower, wheelSize = $wheelSize, id=$id)"
    }
}