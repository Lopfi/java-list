package com.go.daten;

import java.io.File;
import java.util.*;

public class DATENGENERATOR {

    public static String[] dictionaryRead(String pathname) throws Exception
    {
        Scanner s = new Scanner(new File(pathname)).useDelimiter("\\s+");
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext())
        {
            list.add(s.next());
        }
        s.close();
        String[] woerterArray = list.toArray(new String[0]);
        return woerterArray;
    }
}
