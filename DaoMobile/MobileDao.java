package com.xworkz.ecommerceapp.DaoMobile;

import java.sql.ResultSet;

public interface MobileDao {
    int save(String mobile_name, String model, String price, String brand, String storage);

    ResultSet getAllData();

    ResultSet getByMobileIdAndName(int mobile_id, String mobile_name);

    ResultSet getByBrandAndStorage(String brand,String storage);

    ResultSet getByPriceAndModel(String price,String model);

    int updateByBrand(String brand,String storage,String price);

    int onDeleteById(int mobile_id);
}
