package ru.itis.carsrace

class AutoBuilder (type: String) {
    private val instance: Car
    init {
            instance = when (type) {
            "Crossover" -> Crossover()
            "Cabriolet" -> Cabriolet()
            "OffRoadCar" -> OffRoadCar()
            "Sedan" -> Sedan()
            else -> Car()
        }
    }

    fun setBrand(brand: String): AutoBuilder {
        instance.brand = brand
        return this
    }

    fun setModel(model: String): AutoBuilder {
        instance.model = model
        return this
    }

    fun setYear(year: Int): AutoBuilder {
        instance.year = year
        return this
    }

    fun setEnginePower(enginePower: Int): AutoBuilder {
        instance.enginePower = enginePower
        return this
    }

    fun setColor(color: Int?): AutoBuilder {
        if (color != null) {
            instance.color = color
        }
        return this
    }

    fun setRemovableRoof(bool: Boolean): AutoBuilder {
        if (instance is Cabriolet) {
            instance.removableRoof = bool
        }
        return this
    }

    fun setDrive(drive: Crossover.Drives): AutoBuilder {
        if (instance is Crossover) {
            instance.drive = drive
        }
        return this
    }

    fun setWheelSize(size: Int): AutoBuilder {
        if (instance is OffRoadCar) {
            instance.wheelSize = size
        }
        return this
    }

    fun setHaveAbs(bool: Boolean): AutoBuilder {
        if (instance is Sedan) {
            instance.haveABS = bool
        }
        return this
    }

    fun setId(id: Int): AutoBuilder {
        instance.id = id
        return this
    }

    fun build(): Car {
        instance.let { return instance }
    }
}