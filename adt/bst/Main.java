package adt.bst;

import java.util.Arrays;

import adt.bst.dataStructures.BSTImpl;
import adt.bst.models.Employee;

public class Main {
  public static void main(String[] args) {
    // MARK I - Employee Entities Creation
    Employee firstEmployee = new Employee(20L, "John Doe", "jd@example.com", "Engineering");
    Employee secondEmployee = new Employee(44L, "John Doe jr", "jdjunior@example.com", "Engineering");
    Employee thirdEmployee = new Employee(18L, "Uncle Bob", "bob@example.com", "Sales");
    Employee fourthEmployee = new Employee(33L, "George", "george@example.com", "Marketing");
    Employee fifthEmployee = new Employee(64L, "Alice", "alice@example.com", "advertisement");
    Employee sixthEmployee = new Employee(55L, "Laura", "lau@example.com", "ux/ui");
    
    // MARK II - BST Creation
    BSTImpl<Employee> bst = new BSTImpl<Employee>();

    // MARK III - BST Operations
    // TODO: Delete operations in different use cases.
    Arrays.asList(
      firstEmployee, 
      secondEmployee, 
      thirdEmployee, 
      fourthEmployee, 
      fifthEmployee, 
      sixthEmployee
      ).forEach(bst::insert);

    System.out.println("\nPREORDER\n");
    bst.printInPreorder();
    System.out.println("----------------------------------------\n\nINORDER\n");
    bst.printInInorder();
    System.out.println("----------------------------------------\n\nPOSTORDER\n");
    bst.deleteById(18L);
    bst.printInPostorder();
  }
}
