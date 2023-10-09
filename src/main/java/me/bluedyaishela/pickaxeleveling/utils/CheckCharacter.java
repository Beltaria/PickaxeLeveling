package me.bluedyaishela.pickaxeleveling.utils;

import java.util.ArrayList;
import java.util.List;

public class CheckCharacter {

    public List<Integer> getIntegersInStringByWords(String chain)
    {
        List<Integer> integers = new ArrayList<>();
        String[] words = chain.split(" ");

        for (String word : words)
        {
            if (word.startsWith("§f"))
            {
                String stringValue = word.substring(2);
                int value = Integer.parseInt(stringValue);
                integers.add(value);
            }
        }
        return integers;
    }

    public String setIntegersInStringByWords(List<Integer> integers, String chain)
    {
        String[] words = chain.split(" ");
        int integersIndex = 0;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].startsWith("§f"))
            {
                int value = integers.get(integersIndex);

                words[i] = "§f" + value;

                chain = String.join(" ", words);
                integersIndex++;
            }
        }
        return chain;
    }

    public String setStringsInStringByWords(List<String> stringsList, String chain)
    {
        String[] words = chain.split(" ");
        int integersIndex = 0;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].startsWith("§f"))
            {
                String value = stringsList.get(integersIndex);

                words[i] = "§f" + value;

                chain = String.join(" ", words);
                integersIndex++;
            }
        }
        return chain;
    }

    public String getNewLoreLevelUp(List<String> list, String string)
    {
        String[] words = string.split(" ");
        int integersIndex = 0;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].startsWith("§") && !words[i].startsWith("§f") && !words[i].startsWith("§m"))
            {
                String color = list.get(integersIndex);

                words[i] = color + words[i].substring(2);

                string = String.join(" ", words);
                integersIndex++;
            }
        }
        return string;
    }
}
