package me.bluedyaishela.pickaxeleveling.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCharacter {

    public List<Integer> getIntegersInString(String chain)
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

    public String setIntegersInString(List<Integer> integers, String chain)
    {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(chain);

        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;

        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, integers.get(index).toString());
            index++;
        }
        matcher.appendTail(stringBuffer);

        String modifiedString = stringBuffer.toString();

        return modifiedString;
    }

    public String setIntegersInStringByWords(List<Integer> integers, String chain)
    {
        String[] words = chain.split(" ");
        int integersIndex = 0;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].startsWith("§f"))
            {
                String stringValue = words[i].substring(2);
                int value = integers.get(integersIndex);

                words[i] = "§f" + value;

                chain = String.join(" ", words);
                integersIndex++;
            }
        }
        return chain;
    }
}
