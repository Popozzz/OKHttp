package okHttp;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class Customer {

    private String customerId;
    private String customerPassword;
    private String customerPhone;
    private String customerEmail;
    private Short customerSum;

    // Constructors

    /** default constructor */
    public Customer() {
    }

    /** minimal constructor */
    public Customer(String customerId, String customerPassword, String customerPhone) {
        this.customerId = customerId;
        this.customerPassword = customerPassword;
        this.customerPhone = customerPhone;
    }

    /** full constructor */
    public Customer(String customerId, String customerPassword, String customerPhone, String customerEmail,
                    Short customerSum) {
        this.customerId = customerId;
        this.customerPassword = customerPassword;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerSum = customerSum;
    }

    // Property accessors

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPassword() {
        return this.customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhone() {
        return this.customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Short getCustomerSum() {
        return this.customerSum;
    }

    public void setCustomerSum(Short customerSum) {
        this.customerSum = customerSum;
    }


}
