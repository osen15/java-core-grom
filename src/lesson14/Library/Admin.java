package lesson14.Library;


public class Admin extends User {
    Librarian[] librarians = new Librarian[4];

    public Admin(String name, String lastName, long id, String password) {
        super(name, lastName, id, password);

    }

    public boolean logInAdmin(Admin admin, long id, String password) {
        return (admin.getId() == id && admin.getPassword() == password);

    }

    public boolean logOutAdmin(Admin admin) {
        return (logInAdmin(admin, admin.getId(), getPassword())) ? false : true;
    }

    public Librarian[] addLibrarian(Admin admin, Librarian librarian1) {
        int index = 0;
        if (logInAdmin(admin, admin.getId(), getPassword())) {
            for (Librarian librarian : librarians) {
                if (librarian == null) {
                    librarian = librarian1;
                    librarians[index] = librarian;
                    break;
                }
                index++;
            }

        }
        return librarians;

    }

    public Librarian[] deleteLibrarian(Admin admin, long id) {
        int index = 0;
        if (logInAdmin(admin, admin.getId(), getPassword())) {
            for (Librarian librarian : librarians) {
                if (librarian != null && librarian.getId() == id)
                    librarian = null;
                librarians[index] = librarian;

            }
            index++;
        }
        return librarians;
    }

    public void viewLibrarian(Admin admin, long id) {
        if (logInAdmin(admin, admin.getId(), getPassword())) {
            for (Librarian librarian : librarians) {
                if (librarian == null || librarian.getId() != id) {
                    System.err.println("Немає такого в списку або неправильний id - " + id);
                    break;
                } else if (librarian != null && librarian.getId() == id) {
                    System.out.println(librarian);

                }

            }
        }

    }


}