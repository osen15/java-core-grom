package lesson35.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {


   private long id;
   private User user;
   private Room room;
   private Date dateFrom;
   private Date dateTo;
   private double moneyPaid;

    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (Double.compare(order.moneyPaid, moneyPaid) != 0) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (room != null ? !room.equals(order.room) : order.room != null) return false;
        if (dateFrom != null ? !dateFrom.equals(order.dateFrom) : order.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(order.dateTo) : order.dateTo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        temp = Double.doubleToLongBits(moneyPaid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return id +
                ", " + user.getId() +
                ", " + room.getId() +
                ", " + new SimpleDateFormat("dd-MM-yyyy").format(dateFrom) +
                ", " + new SimpleDateFormat("dd-MM-yyyy").format(dateTo) +
                ", " + moneyPaid;
    }
}
