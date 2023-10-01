package web.controller;

import model.Car;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCarTable(@RequestParam(value = "count", required = false) Integer count,
                                Model model) {
        Car car1 = new Car("Renault", 1234, "gray");
        Car car2 = new Car("Nissan", 3456, "white");
        Car car3 = new Car("Ferrari", 5678, "red");
        Car car4 = new Car("Volga", 7890, "black");
        Car car5 = new Car("Suzuki", 7777, "orange");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        int intCount;
        if (count == null) {
            intCount = 5;
        } else {
            intCount = count.intValue();
        }
        CarService carService = new CarServiceImpl();
        List<Car> newCarList = carService.getNewCarList(carList, intCount);
        model.addAttribute("newCarList", newCarList);
        return "cars";
    }

}
