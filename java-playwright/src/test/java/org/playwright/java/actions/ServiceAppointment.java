package org.playwright.java.actions;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import org.playwright.java.ui.FieldServicePage;
import org.playwright.java.ui.FieldServicePage.ServiceAppointmentType;
import org.playwright.java.ui.ServiceAppointmentPopUp;

import static org.playwright.java.ui.FieldServicePage.*;
import static org.playwright.java.ui.FieldServicePage.ServiceAppointmentType.*;

public class ServiceAppointment {
    public static void ChangeStatusAsFailedAfterArrival(Page page) {
        ServiceAppointmentPopUp.edit(page).click();
        setServiceAppointmentToFailed(page);
        ServiceAppointmentPopUp.close(page).click();
    }

    public static void viewServiceAppointmentThat(ServiceAppointmentType appointmentType, Page page) {
        serviceAppointmentThatIs(appointmentType, page).dblclick();
    }

    public static boolean appointmentToolTipValueGreaterThan(String label, Page page) {
        serviceAppointmentThatIs(Dispatched,page).hover();
        int textLength = FieldServicePage.serviceAppointmentToolTipText(label, page).length();
        return textLength > label.length();
    }

    public static boolean appointmentToolTipCheckBoxIsChecked(String label, Page page) {
        serviceAppointmentThatIs(Dispatched,page).hover();
        return serviceAppointmentToolTipCheckBox(label, page).isChecked();
    }

    private static void setServiceAppointmentToFailed(Page page) {
        FrameLocator serviceAppointmentPopUp = ServiceAppointmentPopUp.getServiceAppointmentPopUp(page);
        serviceAppointmentPopUp.getByText("Status").locator("xpath=../following-sibling::td[1]//select").selectOption("Failed After Arrive");
        serviceAppointmentPopUp.locator("select[name*=\"id33:5\"]").selectOption("Glass/Parts Damaged");
        serviceAppointmentPopUp.locator("select[name*=\"id33:7\"]").selectOption("Glass Damaged");
        serviceAppointmentPopUp.locator("div.pbHeader input.btn[value=\"Save Changes\"]").click();
    }

}
