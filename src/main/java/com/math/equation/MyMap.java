package com.math.equation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMap<K,V> extends HashMap {
    @Override
    public String toString() {
        Set<Entry<K, V>> keyset = this.entrySet();
        Iterator<Entry<K, V>> i = keyset.iterator();
        if (!i.hasNext())
            return "";
        StringBuffer buffer = new StringBuffer();
        // buffer.append("{");//注意此程序与源代码的区别
        for (;;) {
            Map.Entry<K, V> me = i.next();
            K key = me.getKey();
            V value = me.getValue();
            buffer.append(key.toString() + ":"+"\t");
            buffer.append(value.toString() + "\n");
            if (!i.hasNext())
                return buffer.toString();
        }
    }
}