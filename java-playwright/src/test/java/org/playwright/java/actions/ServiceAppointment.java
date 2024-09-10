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
        ServiceAppointmentPopUp.setStatusDropDownTo(page).selectOption("Failed After Arrive");
        ServiceAppointmentPopUp.setFailureReasonDropDownTo(page).selectOption("Glass/Parts Damaged");
        ServiceAppointmentPopUp.setSubFailureReasonDropDownTo(page).selectOption("Glass Damaged");
        ServiceAppointmentPopUp.saveChanges(page).click();
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
}
