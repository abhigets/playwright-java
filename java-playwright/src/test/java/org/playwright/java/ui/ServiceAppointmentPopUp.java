package org.playwright.java.ui;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.playwright.java.ui.FieldServicePage.getFieldServiceFrame;

public class ServiceAppointmentPopUp {
    private static FrameLocator getServiceAppointmentPopUp(Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        return fieldServiceTab.frameLocator("iframe[ng-show*=\"selectedSubTabService == 'details'\"]");
    }

    public static Locator edit(Page page) {
        FrameLocator serviceAppointmentPopUp = getServiceAppointmentPopUp(page);
        return serviceAppointmentPopUp.locator("div.pbHeader input[value=\"Edit\"]");
    }

    public static Locator close(Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        return fieldServiceTab.locator(".CloseLightbox");
    }

    public static Locator setStatusDropDownTo(Page page) {
        FrameLocator serviceAppointmentPopUp = getServiceAppointmentPopUp(page);
        return serviceAppointmentPopUp.getByText("Status").locator("xpath=../following-sibling::td[1]//select");
    }

    public static Locator setFailureReasonDropDownTo(Page page) {
        FrameLocator serviceAppointmentPopUp = getServiceAppointmentPopUp(page);
        return serviceAppointmentPopUp.locator("select[name*=\"id33:5\"]");
    }

    public static Locator setSubFailureReasonDropDownTo(Page page) {
        FrameLocator serviceAppointmentPopUp = getServiceAppointmentPopUp(page);
        return serviceAppointmentPopUp.locator("select[name*=\"id33:7\"]");
    }

    public static Locator saveChanges(Page page) {
        FrameLocator serviceAppointmentPopUp = getServiceAppointmentPopUp(page);
        return serviceAppointmentPopUp.locator("div.pbHeader input.btn[value=\"Save Changes\"]");
    }
}
