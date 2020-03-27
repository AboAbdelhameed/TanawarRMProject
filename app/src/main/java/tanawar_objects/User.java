package tanawar_objects;
/**
 *
 */

import java.util.Calendar;

import utils.AccountType;

/**
 *
 */
public class User {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String verifyPassword;
    private Calendar birthday;
    private AccountType accountType;
    private String phone;
    private Calendar registeredDate;
    /**
     *
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param verifyPassword
     * @param birthday
     * @param accountType
     * @param phone
     * @param registeredDate
     */
    public User(String fname, String lname, String email, String password, String verifyPassword,
                Calendar birthday, AccountType accountType, String phone, Calendar registeredDate) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.birthday = birthday;
        this.accountType = accountType;
        this.phone = phone;
        this.registeredDate = registeredDate;
    }
    /**
     *
     * @param email
     * @param password
     */
    public User(String email, String phone , String password) {
        this.email = email;
        this.phone = phone ;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Calendar getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Calendar registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                ", birthday=" + birthday +
                ", accountType=" + accountType +
                ", phone='" + phone + '\'' +
                ", registeredDate=" + registeredDate +
                '}';
    }

}
