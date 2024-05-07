package org.playwright.java.actions;

import com.microsoft.playwright.Page;

import static org.playwright.java.actions.ServiceAppointment.selectAnAppointment;
import static org.playwright.java.ui.FieldServicePage.fieldServiceTabLink;
import static org.playwright.java.ui.FieldServicePage.waitForFieldServicePage;

public class UpdateExistingFieldServiceAppointment {
    public static void updateExistingFieldServiceAppointmentTo(Page page) {
        fieldServiceTabLink(page).click();
        waitForFieldServicePage(page);
        selectAnAppointment(page);
    }

}
