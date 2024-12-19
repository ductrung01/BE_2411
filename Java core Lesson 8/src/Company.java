public class Company {
    private String nameCompany;
    private int codeTax;
    private double revenueCompany;
    public Company(String nameCompany, int codeTax, double revenueCompany) {
        this.nameCompany = nameCompany;
        this.codeTax = codeTax;
        this.revenueCompany = revenueCompany;
    }
    public Company() {}

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void setCodeTax(int codeTax) {
        this.codeTax = codeTax;
    }

    public void setRevenueCompany(double revenueCompany) {
        this.revenueCompany = revenueCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public int getCodeTax() {
        return codeTax;
    }

    public double getRevenueCompany() {
        return revenueCompany;
    }
}
