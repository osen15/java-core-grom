package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (!o1.getChannelName().equals(o2.getChannelName()))
            return o1.getChannelName().compareTo(o2.getChannelName());
        if (!o1.getFingerPrint().equals(o2.getFingerPrint()))
            return o1.getFingerPrint().compareTo(o2.getFingerPrint());
        if (o1.getDateCreated().getTime() > o2.getDateCreated().getTime())
            return -1;
        else if (o1.getDateCreated().getTime() < o2.getDateCreated().getTime())
            return 1;
        else
            return 0;





    }
}
