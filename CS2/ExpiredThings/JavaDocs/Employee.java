 
/** Represents an employee.
 * @author Doug Lowe
 * @author www.LoweWriter.com
 * @version 1.5
 * @since 1.0
*/
public class Employee
{
 private String lastName;
 private String firstName;
 private Double salary;

/** Gets the employee’s last name.
 * @return A string representing the employee’s last
 *     name.
*/
 public String getLastName()
 {
  return this.lastName;
 }
/** Sets the employee’s last name.
 * @param lastName A String containing the employee’s
 *     last name.
*/
 public void setLastName(String lastName)
 {
  this.lastName = lastName;
 }
/** Gets the employee’s first name.
 * @return A string representing the employee’s first
 *     name.
*/
 public String getFirstName()
 {
  return this.firstName;
 }
/** Sets the employee’s first name.
 * @param firstName A String containing the
 *     employee’s first name.
*/
 public void setFirstName(String firstName)
 {
  this.firstName = firstName;
 }
/** Gets the employee’s salary.
 * @return A double representing the employee’s salary.
*/
 public double getSalary()
 {
  return this.salary;
 }
/** Sets the employee’s salary.
 * @param lastName A double containing the employee’s
 *     salary.
*/
 public void setSalary(double salary)
 {
  this.salary = salary;
 }
}