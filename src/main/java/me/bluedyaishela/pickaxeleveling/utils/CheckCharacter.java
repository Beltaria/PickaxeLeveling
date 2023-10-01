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

    public String setTwoIntegerInString(List<Integer> integers, String chain)
    {
        StringBuilder newChain = new StringBuilder(chain);

        for (int i = 0; i < integers.size(); i++) {
            String oldInteger = String.valueOf(integers.get(i));
            String newInteger = "4"; // Remplacez ici par la nouvelle valeur souhaitée (dans cet exemple, "4")
            String regex = "\\b" + oldInteger + "\\b"; // Utilisez \\b pour correspondre à des mots entiers

            newChain = new StringBuilder(newChain.toString().replaceAll(regex, newInteger));
        }


        return newChain.toString();
    }
}
