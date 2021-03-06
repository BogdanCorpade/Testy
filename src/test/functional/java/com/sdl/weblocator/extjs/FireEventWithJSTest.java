package com.sdl.weblocator.extjs;

import com.sdl.selenium.extjs3.button.Button;
import com.sdl.selenium.extjs3.panel.Panel;
import com.sdl.weblocator.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FireEventWithJSTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(FireEventWithJSTest.class);
    
    private Panel simpleForm = new Panel("Simple Form");
    private Button cancelButton = new Button(simpleForm, "Cancel");


    @Test
    public void fireEvent() {
        cancelButton.focus();
        assertTrue(cancelButton.blur());
        assertTrue(cancelButton.mouseOver());
        assertTrue(cancelButton.doubleClickAt());
    }
}
