package com.example.demo.repositories;

import com.example.demo.models.Motorhome;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepoImpl implements IMotorhomeRepo {
    private Connection conn;

    public MotorhomeRepoImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Motorhome motorhome) {
        System.out.println(motorhome.getLicensePlate());
        System.out.println(motorhome.getPricePerDay());
        System.out.println(motorhome.getBeds());
        System.out.println(motorhome.getModel());
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Motorhomes (LicensePlate, Model, Beds, Price, Cleaned, Repaired, MotorhomeActive)" +
                    " VALUES ('" +
                    motorhome.getLicensePlate() + "','" +
                    motorhome.getModel() + "'," +
                    motorhome.getBeds() + "," +
                    motorhome.getPricePerDay() + "," +
                    "true, true, true);");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Motorhome read(int mID) {
        Motorhome motorhomeToReturn = new Motorhome();
        try {
            PreparedStatement getSingleMotorhome = conn.prepareStatement("SELECT * FROM Motorhomes WHERE MotorhomeID='" + mID + "';");
            ResultSet rs = getSingleMotorhome.executeQuery();
            while(rs.next()){
                motorhomeToReturn.setID(rs.getInt(1));
                motorhomeToReturn.setLicensePlate(rs.getString(2));
                motorhomeToReturn.setModel(rs.getString(3));
                motorhomeToReturn.setBeds(rs.getInt(4));
                motorhomeToReturn.setPricePerDay(rs.getDouble(5));
                motorhomeToReturn.setCleaned(rs.getBoolean(6));
                motorhomeToReturn.setRepaired(rs.getBoolean(7));
                motorhomeToReturn.setActive(rs.getBoolean(8));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return motorhomeToReturn;

    }

    @Override
    public List<Motorhome> readAll() {
        List<Motorhome> allMotorhomes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Motorhomes;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Motorhome motorhomeToReturn = new Motorhome();
                motorhomeToReturn.setID(rs.getInt(1));
                motorhomeToReturn.setLicensePlate(rs.getString(2));
                motorhomeToReturn.setModel(rs.getString(3));
                motorhomeToReturn.setBeds(rs.getInt(4));
                motorhomeToReturn.setPricePerDay(rs.getDouble(5));
                motorhomeToReturn.setCleaned(rs.getBoolean(6));
                motorhomeToReturn.setRepaired(rs.getBoolean(7));
                motorhomeToReturn.setActive(rs.getBoolean(8));
                allMotorhomes.add(motorhomeToReturn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }

    @Override
    public boolean update(Motorhome motorhome) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE Motorhomes SET " +
                    " LicensePlate = '"+ motorhome.getLicensePlate() + "'," +
                    " Model = '" + motorhome.getModel() +"'," +
                    " Beds = '" + motorhome.getBeds() +"'," +
                    " Price = '" + motorhome.getPricePerDay() + "'," +
                    " Cleaned = '" + sqlReadBoolean(motorhome.getCleaned()) + "'," +
                    " Repaired = '" + sqlReadBoolean(motorhome.getRepaired()) + "'," +
                    " MotorhomeActive = '" + sqlReadBoolean(motorhome.getActive()) +"'" +
                    " WHERE MotorhomeID = '"+ motorhome.getID() + "';");

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int mID) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Motorhomes WHERE MotorhomeID='" + mID + "';");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public int sqlReadBoolean(boolean bool){
        if(!bool){
            return 0;
        } else {
            return 1;
        }
    }
}
