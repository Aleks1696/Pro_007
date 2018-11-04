package homework10;

import homework10.entity.types.Brand;
import homework10.entity.types.CPU;
import homework10.entity.types.VideoCard;
import homework10.service.LaptopServiceImp;
import homework10.service.LaptopServiceShow;
import homework10.service.LaptopServiceShowImp;
import homework10.service.LaptopServise;
import homework10.util.HibernateUtil;

public class HomeWork10App {
    public static void main(String[] args) {

        LaptopServise laptopServise = new LaptopServiceImp();
        LaptopServiceShow laptopServiceShow = new LaptopServiceShowImp();

        laptopServise.create("Macbook", Brand.Apple,1500, CPU.Intel_Core_I5, VideoCard.Radeon,256);
        laptopServise.create("Macbook_Pro", Brand.Apple,1500, CPU.Intel_Core_I5, VideoCard.Radeon,256);
        laptopServise.create("Macbook_Air", Brand.Apple,800, CPU.Intel_Pentium, VideoCard.Integrated,256);
        laptopServise.create("Macbook_Used", Brand.Apple,400, CPU.Intel_Pentium, VideoCard.Integrated,256);
        laptopServise.create("IdeaPad", Brand.Lenovo,500, CPU.Intel_Pentium, VideoCard.Integrated,1000);
        laptopServise.create("Power", Brand.Samsung,1000, CPU.Intel_Core_i7, VideoCard.Nvidia,512);
        //laptopServiceShow.findByBrand(Brand.Apple).forEach(System.out::println);
        laptopServiceShow.findBetweenPrice(700.,1000.,Brand.Apple).forEach(System.out::println);

       // laptopServerImp.findAll();



        HibernateUtil.getSessionFactory().close();
    }
}
