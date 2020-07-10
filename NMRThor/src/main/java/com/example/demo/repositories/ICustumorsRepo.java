package com.example.demo.repositories;

import com.example.demo.models.Customer;
import com.example.demo.models.Extra;

import java.util.List;

public interface ICustumorsRepo {
    public boolean create(Customer customer);

    public Customer read(String CPR);

    public List<Customer> readAll();

    public boolean update(Customer customer);

    public boolean delete(String CPR);
}
