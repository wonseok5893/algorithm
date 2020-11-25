package standard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class JavaStudy {
    public static void main(String[] args) {
        JavaStatic a = new JavaStatic();
        a.y = 20;
        JavaStatic b = new JavaStatic();
        b.y = 20;
        HashMap<JavaStatic,Integer> map = new HashMap<>();
        map.put(a,1);
        map.put(b,1);
        Set<JavaStatic> javaStatics = map.keySet();
        Iterator<JavaStatic> iterator = javaStatics.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next().hashCode());
        System.out.println(map.size());
    }

    private static class JavaStatic {
        int x;
        int y;
    }
}
