package com.xworkz.ecommerceapp.dao;

import java.sql.ResultSet;

public interface LaptopDao {

    public int save(String brand, String model, String processor, String ram, String price);

    ResultSet getAllData();

    ResultSet getByIdAndBrand(int laptop_id, String brand);

    ResultSet getByprocessorAndBrand(String processor, String brand);

    ResultSet getByRamAndId(String ram,int laptop_id);

    int updateByLaptop_id(int laptop_id,String processor, String brand);

    int onDeleteById(int laptop_id);

}
