package me.bluedyaishela.pickaxeleveling.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCharacter {

    public List<Integer> getTwoIntegerInString(String chain)
    {
        Pattern pattern = Pattern.compile("\\d+"); // Correspond à une séquence de chiffres
        Matcher matcher = pattern.matcher(chain);

        List<Integer> integers = new ArrayList<>();

        while (matcher.find())
        {
            int integer = Integer.parseInt(matcher.group());
            integers.add(integer);
        }

        return integers;
    }
}
