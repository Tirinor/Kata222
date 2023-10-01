package service;

import model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getNewCarList(List<Car> carList, int number) {
        if (number < 1 || number > 5) {
            number = 5;
        }
        List<Car> newCarList = carList;
        return newCarList.subList(0, number);
    }
}
