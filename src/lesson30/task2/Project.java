package lesson30.task2;

public class Project {
  private   String name;
  private   Customer customer;

  public Project(String name, Customer customer) {
    this.name = name;
    this.customer = customer;
  }

  public String getName() {
    return name;
  }

  public Customer getCustomer() {
    return customer;
  }

  @Override
  public String toString() {
    return "Project{" +
            "name='" + name + '\'' +
            ", customer=" + customer +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Project project = (Project) o;

    if (name != null ? !name.equals(project.name) : project.name != null) return false;
    return customer != null ? customer.equals(project.customer) : project.customer == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (customer != null ? customer.hashCode() : 0);
    return result;
  }
}
