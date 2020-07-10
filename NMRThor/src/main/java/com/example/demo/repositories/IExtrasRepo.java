package com.example.demo.repositories;

import com.example.demo.models.Extra;

import java.util.List;

public interface IExtrasRepo {
        // CRUD operations
        public boolean create(Extra extra);

        public Extra read(int extraID);

        public List<Extra> readAll();

        public boolean update(Extra extra);

        public boolean delete(String extraName);
}
