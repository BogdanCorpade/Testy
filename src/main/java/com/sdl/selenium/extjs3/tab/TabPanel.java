package com.sdl.selenium.extjs3.tab;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.extjs3.ExtJsComponent;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.XPathBuilder;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TabPanel extends ExtJsComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(TabPanel.class);

    private TabPanel() {
        setClassName("TabPanel");
        setBaseCls("x-tab-panel");
    }

    public TabPanel(String text) {
        this();
        setText(text, SearchType.EQUALS);
    }

    public TabPanel(WebLocator container, String text) {
        this(text);
        setContainer(container);
    }

    private String getTitlePath() {
        WebLocator header = new WebLocator().setClasses("x-tab-panel-header");
        WebLocator locator = new WebLocator().setText(getPathBuilder().getText()).setContainer(header);
        locator.setSearchTextType(getPathBuilder().getSearchTextType().toArray(new SearchType[getPathBuilder().getSearchTextType().size()]));
        return locator.getXPath();
    }

    /**
     * this method return the path of the main TabPanel (that contains also this Tab/Panel)
     *
     * @return the path of the main TabPanel
     */
    private String getBaseTabPanelPath() {
        String selector = getPathBuilder().getBasePath();
        WebLocator el = new WebLocator().setText(getPathBuilder().getText(), SearchType.EQUALS);
        el.setSearchTextType(getPathBuilder().getSearchTextType().toArray(new SearchType[getPathBuilder().getSearchTextType().size()]));
        selector += (selector.length() > 0 ? " and " : "") + "not(contains(@class, 'x-masked')) and count(*[contains(@class,'x-tab-panel-header')]//*[contains(@class, 'x-tab-strip-active')]" + el.getPath() + ") > 0";
        return "//*[" + selector + "]";
    }

    protected XPathBuilder createXPathBuilder() {
        return new XPathBuilder() {
            /**
             * this method return the path of only one visible div from the main TabPanel
             *
             * @param disabled disabled
             * @return the path of only one visible div from the main TabPanel
             */
            @Override
            public String getItemPath(boolean disabled) {
                String selector = getBaseTabPanelPath();
                selector += "/*/*[contains(@class, 'x-tab-panel-body')]" +  //TODO
                        "/*[not(contains(@class, 'x-hide-display'))]"; // "/" is because is first element after -body
                return selector;
            }
        };
    }

    /**
     * After the tab is set to active will wait 50ms to make sure tab is rendered
     *
     * @return true or false
     */
    public boolean setActive() {
        String baseTabPath = "//*[" + getPathBuilder().getBasePath() + "]";
        String titlePath = baseTabPath + getTitlePath();
        WebLocator titleElement = new WebLocator(getPathBuilder().getContainer()).setElPath(titlePath).setInfoMessage(getPathBuilder().getText() + " Tab");
        LOGGER.info("setActive : " + toString());
        boolean activated;
        try {
            activated = titleElement.click();
        } catch (ElementNotVisibleException e) {
            LOGGER.error("setActive Exception: " + e.getMessage());
            WebLocator tabElement = new WebLocator(getPathBuilder().getContainer()).setElPath(baseTabPath);
            String id = tabElement.getAttributeId();
            String path = "//*[@id='" + id + "']//*[contains(@class, 'x-tab-strip-inner')]";
            String script = "return Ext.getCmp('" + id + "').setActiveTab(" + getTabCount(getPathBuilder().getText(), path) + ");";
            LOGGER.warn("force TabPanel setActive with js: " + script);
            WebLocatorUtils.doExecuteScript(script);
            activated = true; // TODO verify when is not executed
        }
        if (activated) {
            Utils.sleep(300); // need to make sure this tab is rendered
        }
        return activated;
    }

    public int getTabCount(String nameTab, String path) {
        List<WebElement> element = WebDriverConfig.getDriver().findElements(By.xpath(path));
        int count = 0;
        for (WebElement el : element) {
            if (nameTab.equals(el.getText())) {
                LOGGER.debug(count + " : " + el.getText());
                return count;
            }
            count++;
        }
        return -1;
    }
}
