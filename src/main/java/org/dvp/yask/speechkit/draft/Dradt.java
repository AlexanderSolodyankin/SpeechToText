package org.dvp.yask.speechkit.draft;

import org.dvp.yask.speechkit.*;
import org.dvp.yask.speechkit.exception.ClientException;

public class Dradt {
    public static void main(String[] args) {
        try{
            Text text = new Text("test.ogg");
            text.setLang(Lang.RU);
            text.setTopic(Topic.GENERAL);
            text.setFilter(Filter.FALSE);
            text.setFormat(Format.OGGOPUS);


            System.out.println(text.getURL());


//        }catch (ClientException clientException){
//            System.out.println(clientException.getMessage());
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}
