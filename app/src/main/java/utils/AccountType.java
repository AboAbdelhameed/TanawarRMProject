package utils;

/**
 *
 */
public enum AccountType {
    /**
     *
     */
    TEACHER("Teacher"),STUDENT("Student"),PARENT("Parent");
    /**
     *
     */
    private String value;
    /**
     *
     * @param val
     */
    AccountType(String val){
        this.value = val;
    }
    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }
}
