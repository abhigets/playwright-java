package org.playwright.java.actions;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static org.playwright.java.ui.FieldServicePage.getFieldServiceFrame;

public class ServiceAppointment {
    static void selectAnAppointment(Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        fieldServiceTab.locator(".eventStatusTravel.GanttCustomStatus_Arrived").first().dblclick();
        FrameLocator serviceAppointmentPopUp = fieldServiceTab.frameLocator("iframe[ng-show*=\"selectedSubTabService == 'details'\"]");
        serviceAppointmentPopUp.locator("div.pbHeader input[value=\"Edit\"]").click();
        serviceAppointmentPopUp.getByText("Status").locator("xpath=../following-sibling::td[1]//select").selectOption("Failed After Arrive");
        serviceAppointmentPopUp.locator("select[name*=\"id33:5\"]").selectOption("Glass/Parts Damaged");
        serviceAppointmentPopUp.locator("select[name*=\"id33:7\"]").selectOption("Glass Damaged");
        serviceAppointmentPopUp.locator("div.pbHeader input.btn[value=\"Save Changes\"]").click();
        fieldServiceTab.locator(".CloseLightbox").click();
        fieldServiceTab.locator(".dhx_noTravel.GanttCustomStatus_FailedAfterArrive").first().dblclick();
        serviceAppointmentPopUp.getByText("Failed After Arrive").click();
    }

    public static boolean appointmentToolTipValueGreaterThanLabel(Page page, String field) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        fieldServiceTab.locator(".eventStatusDispatched.GanttCustomStatus_Dispatched").first().hover();
        int textLength = fieldServiceTab.locator(".expertTooltip").getByText(field).locator("xpath=..").first().textContent().length();
        return textLength > field.length();
    }

    public static boolean appointmentToolTipCheckBoxIsChecked(Page page, String field) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        fieldServiceTab.locator(".eventStatusDispatched.GanttCustomStatus_Dispatched").first().hover();
        return fieldServiceTab.locator(".expertTooltip").getByText(field).locator("xpath=..").locator("input").isChecked();
    }


}
