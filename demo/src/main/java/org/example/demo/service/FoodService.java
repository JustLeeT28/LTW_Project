package org.example.demo.service;

import org.example.demo.dao.FoodDao;
import org.example.demo.dao.model.FoodCombo;

import java.util.List;

public class FoodService {
    public List<FoodCombo> getFoodCombo() {
        FoodDao foodDao = new FoodDao();
        return foodDao.getFoodCombo();
    }
    public List<FoodCombo> getFoodComboById(int id) {
        FoodDao foodDao = new FoodDao();
        return foodDao.getFoodComboById(id);
    }
}
