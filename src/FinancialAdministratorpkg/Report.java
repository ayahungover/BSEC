
package FinancialAdministratorpkg;

import java.io.Serializable;


public class Report implements Serializable {
    String subject;
    String text;

    public Report(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Report{" + "subject= " + subject + ", text= " + text + '}';
    }
}
