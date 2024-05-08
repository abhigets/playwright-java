package org.playwright.java.ui;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.playwright.java.ui.FieldServicePage.getFieldServiceFrame;

public class ServiceAppointmentPopUp {
    public static FrameLocator getServiceAppointmentPopUp(Page page) {
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
}
