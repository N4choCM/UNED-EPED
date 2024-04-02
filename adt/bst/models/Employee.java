package adt.bst.models;

public class Employee implements Comparable<Employee> {
  // MARK I - Attributes
  private Long id;
  private String name;
  private String email;
  private String department;

  // MARK II - Constructors
  public Employee(Long id, String name, String email, String department) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.department = department;
  }

  // MARK III - Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  // MARK IV - Methods
  @Override
  public String toString() {
    return "Employee Data:\n\t- id=" + id + "\n\t- name=" + name + "\n\t- email=" + email + "\n\t- department=" + department + "\n";
  }

  /**
   * Compares two employees by their id.
   * @return 0 if the ids are equal, 
   * -1 if the id of the current employee is less than the id of the other employee, 
   * 1 otherwise.
   */
  @Override
  public int compareTo(Employee entity) {
    if (id == entity.getId()) {
      return 0;
    } else if (id < entity.getId()) {
      return -1;
    } else {
      return 1;
    }
  }
}
