package main.java.nl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static List<Elf> elfList = new ArrayList<>();
    public static void main(String[] args) {

        String text = TextHolder.getText();
        final Elf[] elf = {new Elf()};
        text.lines().forEach(s -> {
            if (s.isBlank()) {
                elfList.add(elf[0]);
                elf[0] = new Elf();
                return;
            }
            elf[0].addToCalorieItem(Integer.parseInt(s));
        });
        elfList.sort(Comparator.comparingLong(Elf::getTotal));
        System.out.println(elfList.get(elfList.size()-1).getTotal() + elfList.get(elfList.size()-2).getTotal() + elfList.get(elfList.size()-3).getTotal());
    }
}