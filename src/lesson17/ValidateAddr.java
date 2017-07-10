package lesson17;


public class ValidateAddr {
    public static void main(String[] args) {
        String test = "https://www.gromcode.com";
        System.out.println(validate(test));

    }
    private static boolean validate(String address) {
        if (address == null)
            return false;
        if (!address.startsWith("https://") && !address.startsWith("https://"))
            return  false;
            address = address.replace("http://", "");
            address = address.replace("https://", "");


            address = address.replace("www.", "");

        if (!address.contains(".net") && !address.contains(".com") && !address.contains(".org"))
            return false;
        address = address.replace(".net", "");
        address = address.replace(".com", "");
        address = address.replace(".org", "");

        return  checkWord(address);

    }
    private static boolean checkWord(String word) {   // перевірка символів на букву
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }
        return true;
    }

}