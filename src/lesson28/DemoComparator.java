package lesson28;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, null, "aaa", true, new Date());
        Capability capability2 = new Capability(1005, "TRER", "a", false, new Date());
        Capability capability3 = new Capability(900, "DRT", "a", true, new Date());


        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(null);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(null);

      //  capabilities.sort(new IsActiveComparator());
        capabilities.sort(new FullComparator());
      //  capabilities.sort(new DateComparator());
        System.out.println(capabilities);


        Comparator<Capability> comparator = new Comparator<Capability>() {
            //Якщо channelName не дорівнюють - порівнюю по ньому
            //Якщо channelName рівні - переходжу до fingerPrint
            //Якщо fingerPrint не дорівнюють - порівнюю по ньому
            //Якщо fingerPrint рівні - переходжу до dateCreated
            //Якщо dateCreated не дорівнюють - порівнюю по ньому
            //Якщо dateCreated рівні - об'єкти рівні.


            @Override
            public int compare(Capability o1, Capability o2) {
                return 0;
            }
        };
    }


}
