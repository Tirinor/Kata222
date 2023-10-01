package service;
import model.Car;

import java.util.List;

public interface CarService {
      List<Car> getNewCarList(List<Car> carList, int number);
}
