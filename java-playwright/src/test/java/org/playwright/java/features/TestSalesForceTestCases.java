package org.playwright.java.features;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.playwright.java.common.PlaywrightManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.playwright.java.actions.NavigateToUATEnv.navigateToUATEnv;
import static org.playwright.java.actions.ServiceAppointment.appointmentToolTipCheckBoxIsChecked;
import static org.playwright.java.actions.ServiceAppointment.appointmentToolTipValueGreaterThanLabel;
import static org.playwright.java.actions.UpdateExistingFieldServiceAppointment.updateExistingFieldServiceAppointmentTo;
import static org.playwright.java.questions.IamOnPlaywrightWiki.amIOnHomePage;

public class TestSalesForceTestCases {

    static PlaywrightManager playwrightManager;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwrightManager = new PlaywrightManager();
        playwrightManager.launchBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        playwrightManager.closeBrowser();
    }

    @BeforeEach
    void createPage() {
        page= playwrightManager.createContextAndPage();
    }

    @AfterEach
    void closeContext() {
        playwrightManager.closeContext();
    }


    //FOUK-127 Flag Failed Jobs on Arrival
    @Test
    void shouldBeAbleToSetFailedOnArriveState()  {
        navigateToUATEnv(page);
        assertTrue(amIOnHomePage(page));
        updateExistingFieldServiceAppointmentTo(page);
    }

    //FOUK-145 Appointment Tooltip
    @Test
    void shouldBeAbleToSeeAppointmentTooltip()  {
        navigateToUATEnv(page);
        assertTrue(amIOnHomePage(page));
        //Account ID:  M SMITH
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Account ID:"));
        //Remedy Job Id:  000001024673696
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Remedy Job Id:"));
        // Work Type ID:  Stock Collect
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Work Type ID:"));
        // Zip/Postal Code:  MK44 3US
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Zip/Postal Code:"));
        // Is Branch Appointment?:
        assertTrue(appointmentToolTipCheckBoxIsChecked(page,"Is Branch Appointment?:"));
        // Make Of Vehicle:  MERCEDES CARS
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Make Of Vehicle:"));
        // Model Of Vehicle:  GLA
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Model Of Vehicle:"));
        // Gantt Label:  M SMITH / FP67FSD
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Gantt Label:"));
        // Work Order Number:  00003862
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Work Order Number:"));
        // Status:  Dispatched
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Status:"));
        // Earliest Start Permitted:  Tue, 30 Apr 2024 07:00
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Earliest Start Permitted:"));
        // Due Date:  Fri, 3 May 2024 10:30
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Due Date:"));
        // Start Fri, 3 May 2024 08:00
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Start"));
        // Finish Fri, 3 May 2024 08:05
        assertTrue(appointmentToolTipValueGreaterThanLabel(page,"Finish"));
    }

}