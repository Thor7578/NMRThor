package com.example.demo.repositories;

import com.example.demo.models.Date;
import com.example.demo.models.Season;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SeasonRepoImpl implements ISeasonsRepo {
    private Connection conn;

    public SeasonRepoImpl(){ this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Season season) {
        return false;
    }

    @Override
    public Season read(int sID) {
        Season seasonToReturn = new Season();
        Date startDate = new Date();
        Date endDate = new Date();

        //The benefits and the drawbacks of making your own Date-type.
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement endDateDay = conn.prepareStatement("SELECT DAY(SeasonEndDate) FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement endDateMonth = conn.prepareStatement("SELECT MONTH(SeasonEndDate) FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement endDateYear = conn.prepareStatement("SELECT YEAR(SeasonEndDate) FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement startDateDay = conn.prepareStatement("SELECT DAY(SeasonStartDate) FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement startDateMonth = conn.prepareStatement("SELECT MONTH(SeasonStartDate) FROM Seasons WHERE SeasonID="+sID+";");
            PreparedStatement startDateYear = conn.prepareStatement("SELECT YEAR(SeasonStartDate) FROM Seasons WHERE SeasonID="+sID+";");
            ResultSet rs = ps.executeQuery();

            ResultSet dates = endDateDay.executeQuery();
            dates.next();
            endDate.setDay(dates.getInt(1));

            dates = endDateMonth.executeQuery();
            dates.next();
            endDate.setMonth(dates.getInt(1));

            dates = endDateYear.executeQuery();
            dates.next();
            endDate.setYear(dates.getInt(1));

            dates = startDateDay.executeQuery();
            dates.next();
            startDate.setDay(dates.getInt(1));

            dates = startDateMonth.executeQuery();
            dates.next();
            startDate.setMonth(dates.getInt(1));

            dates = startDateYear.executeQuery();
            dates.next();
            startDate.setYear(dates.getInt(1));

            seasonToReturn.setSeasonEndDate(endDate);
            seasonToReturn.setSeasonStartDate(startDate);

            while(rs.next()){
                seasonToReturn.setSeasonID(rs.getInt(1));
                seasonToReturn.setSeasonName(rs.getString(2));
                seasonToReturn.setSeasonDiscount(rs.getDouble(3));
            }
        } catch(SQLException s){
            s.printStackTrace();
        }

        return seasonToReturn;
    }

    @Override
    public List<Season> readAll() {
        return null;
    }

    @Override
    public boolean update(Season season) {
        return false;
    }

    @Override
    public boolean delete(int sID) {
        return false;
    }
}
