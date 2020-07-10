package com.example.demo.repositories;

import com.example.demo.models.Extra;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExtrasRepoImpl implements IExtrasRepo {
    private Connection conn;

    public ExtrasRepoImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Extra extra) {
        return false;
    }

    public Extra read(int extraID) {
        Extra extraToReturn = new Extra();
        try {
            PreparedStatement getSingleExtra = conn.prepareStatement("SELECT * FROM extras WHERE extraID='" + extraID + "'");
            ResultSet rs = getSingleExtra.executeQuery();
            while(rs.next()){
                extraToReturn.setExtraID(rs.getInt(1));
                extraToReturn.setExtraName(rs.getString(2));
                extraToReturn.setExtraPrice(rs.getDouble(3));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return extraToReturn;
    }

    @Override
    public List<Extra> readAll() {
        return null;
    }

    @Override
    public boolean update(Extra extra) {
        return false;
    }

    @Override
    public boolean delete(String extraName) {
        return false;
    }


}
