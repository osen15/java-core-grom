package lesson3;


public class MoneyFromWork {
    public static void main(String[] args) {
        System.out.printf(String.valueOf(money(8, 70)));
    }
    static double money(int moneyByHour, int hoursByWeek) {
        double m = 0;
        if ( moneyByHour >= 8 && hoursByWeek <= 40) {
            m = moneyByHour * hoursByWeek;
        }
        else if(moneyByHour >= 8 && hoursByWeek > 40 && hoursByWeek <= 60){
            m = moneyByHour * (40 + (Math.abs(40 - hoursByWeek)) * 1.5);
        }
        return m;
    }
}