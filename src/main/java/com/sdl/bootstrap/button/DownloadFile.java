package com.sdl.bootstrap.button;

import com.sdl.selenium.web.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class DownloadFile extends WebLocator implements Download {
    private static final Logger logger = Logger.getLogger(DownloadFile.class);

    public DownloadFile() {
        setClassName("DownloadFile");
        setBaseCls("btn");
        setTag("button");
    }

    /**
     * @param container parent
     */
    public DownloadFile(WebLocator container) {
        this();
        setContainer(container);
    }

    public DownloadFile(WebLocator container, String label) {
        this(container);
        setLabel(label);
    }

    /**
     * Download file with AutoIT. Work only on FireFox.
     * Use only this: button.download("C:\\TestSet.tmx");
     * return true if the downloaded file is the same one that is meant to be downloaded, otherwise returns false.
     * @param filePath e.g. "C:\\TestSet.tmx"
     */
    @Override
    public boolean download(String filePath) {
        openBrowse();
        return RunExe.getInstance().download(filePath);
    }

    /**
     * Download file.
     * return true if the downloaded file is the same one that is meant to be downloaded, otherwise returns false.
     * @param filePath e.g. "D:\\temp\\text.docx""
     */
    public boolean assertDownload(String filePath) {
        openBrowse();
        File file = new File(filePath);
        FileUtils.waitFor(file, 5);
        return file.exists() && filePath.equals(file.getAbsolutePath());
    }

    private void openBrowse(){
        WebDriver driver = WebDriverConfig.getDriver();
        driver.switchTo().window(driver.getWindowHandle());
        focus();
        Actions builder = new Actions(driver);
        builder.moveToElement(currentElement).build().perform();
        builder.click().build().perform();
        driver.switchTo().defaultContent();
    }
}