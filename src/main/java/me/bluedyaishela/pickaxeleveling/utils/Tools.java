package me.bluedyaishela.pickaxeleveling.utils;

import com.sun.org.glassfish.gmbal.DescriptorFields;

import java.util.List;

public class Tools {

    @DescriptorFields("Line of Lore Color White")
    public String getAllAfterWhiteColor(String string)
    {
        String white_color = "§f";
        int index = string.indexOf(white_color);
        if (index != -1)
        {
            return string.substring(index + white_color.length()).trim();
        }
        return null;
    }

    public String setNewOptionInLore(String option, String string)
    {
        String[] words = string.split(" ");

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].startsWith("§f"))
            {
                words[i] = "§f" + option;

                string = String.join(" ", words);
            }
        }
        return string;
    }

}
