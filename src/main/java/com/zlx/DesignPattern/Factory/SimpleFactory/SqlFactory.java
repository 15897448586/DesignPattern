package com.zlx.DesignPattern.Factory.SimpleFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂
 * 场景：现在我有mysql，sqlserver,Oracle,postgres等数据库，
 * 有一个配置文件 service.config,需要根据配置取加载数据库
 * @author zlx
 */
public class SqlFactory {
    static Map<String,DataBase> map = new HashMap<>();
    static {
        map.put("mysql",new Mysql());
        map.put("postgres",new Postgres());
        map.put("sqlserver",new SqlServer());
        map.put("oracle",new Oracle());
    }
    public DataBase createDataBase(String database){
        String key = database.toLowerCase();
        if(!map.containsKey(key)){
            throw new RuntimeException("当前数据库不存在");
        }
        return  map.get(key);
    }

    public static void main(String[] args) {
        SqlFactory factory = new SqlFactory();
        DataBase dataBase = factory.createDataBase("mysql");
        String s = dataBase.connectDataBase();
    }
}
