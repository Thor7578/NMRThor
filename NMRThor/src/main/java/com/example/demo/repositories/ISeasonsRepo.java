package com.example.demo.repositories;

import com.example.demo.models.Season;

import java.util.List;

public interface ISeasonsRepo {
    public boolean create(Season season);

    public Season read (int sID);

    public List<Season> readAll();

    public boolean update(Season season);

    public boolean delete(int sID);
}
