package com.example.demo.repositories;

import com.example.demo.models.Motorhome;

import java.util.List;

public interface IMotorhomeRepo {

    public boolean create(Motorhome motorhome);

    public Motorhome read (int mID);

    public List<Motorhome> readAll();

    public boolean update(Motorhome motorhome);

    public boolean delete(int mID);


}
