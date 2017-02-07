package yang.hong3.com.administrativedivision.address;

/**
 * Created by hong3 on 2016/12/9.
 */

public class Constences {

    public static final String CITY_DBNAME = "administrative_division.db";
    public static final String TABLE_PROVINCE = "province";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_DISTINGUISH = "distinguish";
    public static final String ITEM_PROVINCE_ID = "provintId";
    public static final String ITEM_PROVINCE_NAME = "provinceName";
    public static final String ITEM_CITY_ID = "cityId";
    public static final String ITEM_CITY_NAME = "cityName";
    public static final String ITEM_CITY_PROVINCEID = "provinceId";
    public static final String ITEM_DISTINGUISH_ID = "distinguishId";
    public static final String ITEM_DISTINGUISH_NAME = "distinguishName";
    public static final String ITEM_DISTINGUISH_CITYID = "cityId";
    public static final String CREAT_PROVINCE_TABLE = "create table province(_id integer primary key,provintId integer,provinceName text)";
    public static final String CREAT_City_TABLE = "create table city(_id integer primary key,cityId integer,cityName text,provinceId integer)";
    public static final String CREAT_DISTINFGUISH_TABLE = "create table distinguish(_id integer primary key,distinguishId integer,distinguishName text,cityId integer)";

}
