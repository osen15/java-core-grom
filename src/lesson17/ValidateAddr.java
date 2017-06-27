package lesson17;

public class ValidateAddr {
    public static void main(String[] args) {
        String test = "http://gromcode.com";
        System.out.println(validate(test));

    }

    private static boolean validate(String address) {
        if (address.isEmpty() && address == null)
            return false;
        String[] domens = new String[]{".com", ".org", ".net"};
        address.trim();
        if (address.substring(0, 7).equals("http://") || (address.substring(0, 8).equals("https://"))) {
            for (String domen : domens) {
                if (address.substring(address.length() - 4, address.length()).equals(domen)) {
                    return true;
                } else return false;
            }
        }
        return false;
    }
}