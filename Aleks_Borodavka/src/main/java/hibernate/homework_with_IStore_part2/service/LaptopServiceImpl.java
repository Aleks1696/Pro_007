package hibernate.homework_with_IStore_part2.service;

import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;
import hibernate.homework_with_IStore_part2.dao.*;
import hibernate.homework_with_IStore_part2.entity.CPU;
import hibernate.homework_with_IStore_part2.entity.Laptop;
import hibernate.homework_with_IStore_part2.entity.Manufacturer;
import hibernate.homework_with_IStore_part2.entity.RAM;
import hibernate.homework_with_IStore_part2.entity.types.CPUs;
import hibernate.homework_with_IStore_part2.entity.types.RAM_Type;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LaptopServiceImpl implements LaptopService {

    private CPU_DAO cpuDao;
    private RAM_DAO ramDao;
    private Manufacturer_DAO manufacturerDao;
    private Laptop_DAO laptopDao;

    public LaptopServiceImpl() {
        cpuDao = new CPU_DAO_Impl();
        ramDao = new RAM_DAO_Impl();
        manufacturerDao = new Manufacturer_DAO_Impl();
        laptopDao = new Laptop_DAO_Impl();
    }

    @Override
    public List<Laptop> findByManufacturer(Manufacturers manufacturerFromEnum) {
        List<Manufacturer> manufacturerList = manufacturerDao.findAll();
        for (Manufacturer manufacturer1 : manufacturerList) {
            if (manufacturer1.getManufacturerName().equals(manufacturerFromEnum)) {
                return manufacturer1.getLaptopListByManufacturer();
            }
        }
        return null;
    }

    @Override
    public List<Laptop> findByManufactureDate(GregorianCalendar manufactureDate) {
        List<Laptop> laptopList = laptopDao.findAll();
        List<Laptop> laptopListByManufactureDate = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            if (laptop.getManufactureDate().equals(manufactureDate)) {
                laptopListByManufactureDate.add(laptop);
            }
        }
        return laptopListByManufactureDate;
    }

    @Override
    public List<Laptop> findByCharacteristic(CPUs cpuFromEnum) {
        List<CPU> cpuList = cpuDao.findAll();
        for (CPU cpu1 : cpuList) {
            if (cpu1.getCpuModel().equals(cpuFromEnum)) {
                return cpu1.getLaptopListWithCPU();
            }
        }
        return null;
    }

    @Override
    public List<Laptop> findByCharacteristic(RAM_Type ramTypeFromEnum) {
        List<RAM> ramList = ramDao.findAll();
        for (RAM ram : ramList) {
            if (ram.getRamType().equals(ramTypeFromEnum)) {
                return ram.getLaptopListWithRAM();
            }
        }
        return null;
    }
}
