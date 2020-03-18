package com.company.hashtable;

import com.company.singleton.Database;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.io.IOException;
import java.util.*;

public class hash {
    public static void main(String[] args) throws IOException {
        Hashtable<String, Boolean> htb = new Hashtable<>();
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("nhap key: ");
//            String key = scanner.nextLine();
//            System.out.print("nhap value: ");
//            Boolean value = scanner.nextBoolean();
//            htb.put(key,value);
//            if (key.equals("end")) {
//                break;
//            }
//        }
//        for (String k: htb.keySet()) {
//            Boolean v = htb.get(k);
//            System.out.println("key: "+k+", value: "+v.toString());
//        }
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Iterator<String> is = list.iterator();
        while (is.hasNext()) {
            System.out.println(is.next());
        }

        Map<String, Boolean> hst = new HashMap<>();
        hst.put("sdf",false);
        hst.put("sdf2",true);
        Iterator it = hst.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry tmp = (Map.Entry) it.next();
            System.out.println(tmp.getKey() +" = "+ tmp.getValue());
        }
    }
}
