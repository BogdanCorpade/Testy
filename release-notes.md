RELEASE NOTES
-------------
**Release Notes for Testy 1.8.3-SNAPSHOT**

**Release Notes for Testy 1.8.2**
- add isDisplayed method in WebLocator
- fix properties.load from inputStream correctly
- add template for title
- add try and catch for WebDriverException at doClick and submit
- add getCssValue(String propertyName) method in WebLocator
- add profile.preference.dom.disable_beforeunload = true for Firefox
- add setTemplateTitle(WebLocator titleEl)
- setTitle(final String title, SearchType ...searchType) accept SearchType
- update webdriver version 2.47.0

**Release Notes for Testy 1.8.1**
- add isDisplayed, isEnabled and submit method in WebLocatorDriverExecutor

**Release Notes for Testy 1.8.0**
- remove deprecated classes and methods
- remove gets deprecated methods from WebLocatorAbstractBuilder

**Release Notes for Testy 1.7.17**
- create XPathBuilder
- make gets deprecated methods from WebLocatorAbstractBuilder
- change when use in code deprecated methods
- add new property weblocator.min.chars.toType=0 in webLocator.properties
- add resultIdx

**Release Notes for Testy 1.7.16**
- remove deprecated classes and methods (before update to this version make sure you update to Testy 1.7.15 first to see what classes/methods need to migrate)
- rename getTableCell(int columnIndex, TableCell... byCells) in getCell(int columnIndex, TableCell... byCells) for table and GridPanel

**Release Notes for Testy 1.7.15**
- Organize classes packages (mark package com.sdl.bootstrap.* deprecated, and other classes and methods)

**Release Notes for Testy 1.7.8-SNAPSHOT**
- improvement WebDriverConfig.getWebDriver(...);

**Release Notes for Testy 1.7.7-SNAPSHOT**
- webdriver version 2.44.0 supported ff 33

**Release Notes for Testy 1.7.6-SNAPSHOT**
- webdriver version 2.43.0 supported ff 31, 32

**Release Notes for Testy 1.7.5-SNAPSHOT**
- webdriver version 2.42.2
- fix TableCell accept visibility
- add Tooltip class
- fix slow bug
- improvement upload.exe

**Release Notes for Testy 1.7.3-SNAPSHOT**
- revert void fireEventWithJS
- remove unused Utils.fixPathSelector
- improvement Row with tableCell.setTag("th")
- improvement TableCell accept array of SearchTypes

**Release Notes for Testy 1.7.2-SNAPSHOT**
- webdriver version 2.41
- move getDriver in WebDriverConfig
- remove deprecated class and methods
- assertDownload works with localhost-firefox.properties
- fix SimpleMultipleSelect path
- sendKeys return null if element doesn't ready;
- move assertDownload(String filePath) in download(String filePath)
- add Utils.waitFileIfIsEmpty(File file), Wait 5 seconds.
- move Utils from com.extjs.selenium.Utils to com.sdl.selenium.web.utils.Utils;
- create FileUtils
- convert to boolean fireEventWithJS
- add weblocator.log.logXPathEnabled=false and weblocator.defaults.searchType=contains
- has make protected
- add MultiSelect class

**Release Notes for Testy 1.7.1**
- improvement waitToRender() with WebDriverWait
- fixed when Button text or Label of TextField contains quotes.
- add constructor with container for all elements
- change setName("name") from contains(@name,'name') in @name='name'
- improvement Utils.getEscapeQuotesText()
- improvement getBasePathSelector()
- implemented type attribute for SimpleTextField.java
- rename Span in UneditableInput
- add WebLink class
- improvement com.sdl.selenium.extjs3.button.Button.click()
- rename attribute  excludeCls in excludeClasses list
- rename attribute deepness in elPathSuffix
- move specification Browser in WebDriverConfig
- remove methods type(String text) and typeKeys(String text) from WebLocator
- add interface ITextField
- move copyToClipboard in Utils
- mark setCls(final String cls) and getCls() Deprecate
- improvement maximize method from Panel
- add try in executeScript. findElement should not log "Element not found after" when element is not found.
- add tests to WebLocator for toString method : shouldShowClassInToStringWhenHasOneClass and shouldShowClassesInToStringWhenHasManyClass
- improvement getItemPathText with normalize-space
- add InputButton class
- change Boolean in boolean into WebLocatorAbstractBuilder
- rename setSearchTextType in setSearchTextTypes witch accept list
- improvement getItemPathText() for cases where the item has multiple enters
- add SearchType enum TRIM, CHILD_NODE, DEEP_CHILD_NODE
- update setText(final String text, final SearchType ...searchType) with SearchType options

**Release Notes for Testy 1.6**
- Improvement setValue for TextField
- Add method isSamePath()
- Add logger.debug("currentElement already found one time: " + el); in method findElement()
- Add setter and getter for currentElementPath
- Verifica daca elemenetul exista cand a aparut exceptia StaleElementReferenceException si apoi face din nou click
- Add more info about elements into intemToString
- remove upload(String[] filePath, String uploadWindowName)
- Add doSendKeys method
- Improvement update.exe
- use setter com.sdl.bootstrap.button.UploadFile
