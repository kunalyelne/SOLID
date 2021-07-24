package I

/*
*>>Here the ICar interface is filled with all the types of methods a car would have
* but some methods are just unnecessary or are not supported by some cars
* Ex: Sunroof might not present in car...
* Ex: A car might be electric car, then start/Close Engine would be waste
*
*>>Solution: Follow Interface Segregation Principle (ISP) by avoiding fat interfaces
*  and dividing/grouping methods in different interfaces.
interface ICar {
    fun startEngine()
    fun stopEngine()
    fun openSunroof()
    fun closeSunroof()
    fun gearBox()
    fun steeringControl()
    //...
}
class Car: ICar{
    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun openSunroof() {
        TODO("Not yet implemented")
    }

    override fun closeSunroof() {
        TODO("Not yet implemented")
    }
}
 */

interface ICar {
    fun gearBox()
    fun steeringControl()
    //...
}
interface IManualCar: ICar {
    fun gearControl()
}
interface IAutoCar: ICar {
    fun autoControl()
}
interface IEngine {
    fun startEngine()
    fun stopEngine()
    fun fuelIndicator()
    //...
}
interface IElectric {
    fun ignitionOn()
    fun ignitionOff()
    fun charge()
    //...
}

interface ISunRoof {
    fun openSunroof()
    fun closeSunroof()
}
class ManualGearEngineCar: IManualCar, IEngine{
    override fun gearControl() {
        TODO("Not yet implemented")
    }

    override fun gearBox() {
        TODO("Not yet implemented")
    }

    override fun steeringControl() {
        TODO("Not yet implemented")
    }

    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun fuelIndicator() {
        TODO("Not yet implemented")
    }
}

class AutoElectricCar: IAutoCar, IElectric {
    override fun autoControl() {
        TODO("Not yet implemented")
    }

    override fun gearBox() {
        TODO("Not yet implemented")
    }

    override fun steeringControl() {
        TODO("Not yet implemented")
    }

    override fun ignitionOn() {
        TODO("Not yet implemented")
    }

    override fun ignitionOff() {
        TODO("Not yet implemented")
    }

    override fun charge() {
        TODO("Not yet implemented")
    }
}

class ManualEngineWithSunroofCar: IManualCar, IEngine, ISunRoof {
    override fun gearControl() {
        TODO("Not yet implemented")
    }

    override fun gearBox() {
        TODO("Not yet implemented")
    }

    override fun steeringControl() {
        TODO("Not yet implemented")
    }

    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun fuelIndicator() {
        TODO("Not yet implemented")
    }

    override fun openSunroof() {
        TODO("Not yet implemented")
    }

    override fun closeSunroof() {
        TODO("Not yet implemented")
    }
}