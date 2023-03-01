package hw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import unit_test.hw.Car;
import unit_test.hw.Motorcycle;
import unit_test.hw.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {
    Car CAR = new Car("BMW", "XZ", 2023);
    Motorcycle MOTORCYCLE = new Motorcycle("XZ", "ZX", 2023);

    @Test
    @DisplayName("Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)")
    public void testCarIsInstanceOfVehicle() {
        assertThat(CAR).isInstanceOf(Vehicle.class);
    }

    @Test
    @DisplayName("Проверка того, объект Car создается с 4-мя колесами")
    public void testFourWheelsOnCar() {
        assertThat(CAR.getNumWheels()).isEqualTo(4);
    }

    @Test
    @DisplayName("Проверка того, объект Motorcycle создается с 2-мя колесами")
    public void testFourWheelsOnMotorcycle() {
        assertThat(MOTORCYCLE.getNumWheels()).isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())")
    public void testCarReachesSpeedInTestDriving() {
        CAR.testDrive();

        assertThat(CAR.getSpeed()).isEqualTo(60);
    }

    @Test
    @DisplayName("Проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())")
    public void testMotorcycleDevelopsSpeedInTestDriving() {
        MOTORCYCLE.testDrive();

        assertThat(MOTORCYCLE.getSpeed()).isEqualTo(75);
    }

    @Test
    @DisplayName("Проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)")
    public void testInParkingCarStops() {
        CAR.testDrive();
        CAR.park();

        assertThat(CAR.getSpeed()).isEqualTo(0);
    }

    @Test
    @DisplayName("Проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)")
    public void testInParkingMotorcycleStops() {
        MOTORCYCLE.testDrive();
        MOTORCYCLE.park();

        assertThat(MOTORCYCLE.getSpeed()).isEqualTo(0);
    }
}
