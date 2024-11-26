package com.example.sb_online_shop;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sb_online_shop.domain.Car;
import com.example.sb_online_shop.domain.CarRepository;
import com.example.sb_online_shop.domain.Owner;
import com.example.sb_online_shop.domain.OwnerRepository;

@SpringBootApplication
public class SbOnlineShop implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SbOnlineShop.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SbOnlineShop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Créez et enregistrez les propriétaires
        Owner owner1 = new Owner("John", "DOE");
        Owner owner2 = new Owner("Fatima", "KHAN");
        Owner owner3 = new Owner("Mike", "DIENG");

        ownerRepository.saveAll(Arrays.asList(owner1, owner2, owner3));

        // Créez et enregistrez les voitures
        Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
        Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner3);

        carRepository.saveAll(Arrays.asList(car1, car2, car3));

        // Affichez les voitures enregistrées
        for (Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel());
        }

        // Affichez les propriétaires enregistrés
        for (Owner owner : ownerRepository.findAll()) {
            logger.info(owner.getFirstname() + " " + owner.getLastname());
        }
    }
}
