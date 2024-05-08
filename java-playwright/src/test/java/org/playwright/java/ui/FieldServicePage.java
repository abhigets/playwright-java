package org.playwright.java.ui;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FieldServicePage {
    public enum ServiceAppointmentType {
        Arrived(".eventStatusTravel.GanttCustomStatus_Arrived"),
        Dispatched(".eventStatusDispatched.GanttCustomStatus_Dispatched"),
        FailedOnArrival(".dhx_noTravel.GanttCustomStatus_FailedAfterArrive");

        private final String name;

        ServiceAppointmentType(String s) {
            name = s;
        }
    }
    public static Locator fieldServiceTabLink(Page page) {
        page.waitForSelector("a[title=\"Field Service\"]");
        return page.locator("a[title=\"Field Service\"]");
    }
    public static void waitForFieldServicePage(Page page) {
        page.waitForSelector("iframe[title=\"Field Service\"]").contentFrame();
    }
    public static FrameLocator getFieldServiceFrame(Page page) {
        return page.frameLocator("iframe[title=\"Field Service\"]");
    }

    public static Locator serviceAppointmentThatIs(ServiceAppointmentType appointmentType, Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        return fieldServiceTab.locator(appointmentType.name).first();
    }

    public static Locator serviceAppointmentToolTipCheckBox(String field, Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        return fieldServiceTab.locator(".expertTooltip").getByText(field).locator("xpath=..").locator("input");
    }

    public static String serviceAppointmentToolTipText(String field, Page page) {
        FrameLocator fieldServiceTab = getFieldServiceFrame(page);
        return fieldServiceTab.locator(".expertTooltip").getByText(field).locator("xpath=..").first().textContent();
    }
}
