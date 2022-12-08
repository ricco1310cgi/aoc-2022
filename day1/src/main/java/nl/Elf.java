package main.java.nl;

import java.util.ArrayList;
import java.util.List;

public class Elf {
    List<Integer> calorieItemList = new ArrayList<>();

    public void addToCalorieItem(int valueToAdd) {
        calorieItemList.add(valueToAdd);
    }

    public long getTotal() {
        return calorieItemList.stream().mapToInt(Integer::intValue).sum();
    }
}
