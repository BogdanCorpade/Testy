package com.sdl.selenium.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to simple construct xpath for WebLocator's
 */
public abstract class WebLocatorAbstractBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLocatorAbstractBuilder.class);

    private XPathBuilder pathBuilder = createXPathBuilder();

    protected XPathBuilder createXPathBuilder() {
        return new XPathBuilder();
    }

    /**
     * <p><strong><i>Used for finding element process (to generate xpath address)</i></strong></p>
     * @return {@link XPathBuilder}
     */
    public XPathBuilder getPathBuilder() {
        return pathBuilder;
    }

    protected WebLocatorAbstractBuilder() {}

    // =========================================
    // ==========       setters     ============
    // =========================================

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param root If the path starts with // then all elements in the document which fulfill following criteria are selected. eg. // or /
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setRoot(final String root) {
        pathBuilder.setRoot(root);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param tag (type of DOM element) eg. input or h2
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setTag(final String tag) {
        pathBuilder.setTag(tag);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param id eg. id="buttonSubmit"
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setId(final String id) {
        pathBuilder.setId(id);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * Once used all other attributes will be ignored. Try using this class to a minimum!
     *
     * @param elPath absolute way (xpath) to identify element
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setElPath(final String elPath) {
        pathBuilder.setElPath(elPath);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param baseCls base class
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setBaseCls(final String baseCls) {
        pathBuilder.setBaseCls(baseCls);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Find element with <b>exact math</b> of specified class (equals)</p>
     *
     * @param cls class of element
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setCls(final String cls) {
        pathBuilder.setCls(cls);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Use it when element must have all specified css classes (order is not important).</p>
     * <ul>
     * <li>Provided classes must be conform css rules.</li>
     * </ul>
     *
     * @param classes list of classes
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setClasses(final String... classes) {
        pathBuilder.setClasses(classes);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T setChildNodes(final WebLocator... childNodes) {
        pathBuilder.setChildNodes(childNodes);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param excludeClasses list of class to be excluded
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setExcludeClasses(final String... excludeClasses) {
        pathBuilder.setExcludeClasses(excludeClasses);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param name eg. name="buttonSubmit"
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setName(final String name) {
        pathBuilder.setName(name);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param text       with which to identify the item
     * @param searchType type search text element: see more details see {@link SearchType}
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setText(final String text, final SearchType... searchType) {
        pathBuilder.setText(text, searchType);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param searchTextType accepted values are: {@link SearchType#EQUALS}
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setSearchTextType(SearchType... searchTextType) {
        pathBuilder.setSearchTextType(searchTextType);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param searchLabelType accepted values are: {@link SearchType}
     * @param <T> the element which calls this method
     * @return this element
     */
    private <T extends WebLocatorAbstractBuilder> T setSearchLabelType(SearchType... searchLabelType) {
        pathBuilder.setSearchTextType(searchLabelType);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param style of element
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setStyle(final String style) {
        pathBuilder.setStyle(style);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param title of element
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setTitle(final String title, SearchType ...searchType) {
        pathBuilder.setTitle(title, searchType);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T setTemplateTitle(WebLocator titleEl) {
        pathBuilder.setTemplateTitle(titleEl);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Example:</p>
     * <pre>
     *     TODO
     * </pre>
     *
     * @param key          suffix key
     * @param elPathSuffix additional identification xpath element that will be added at the end
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setElPathSuffix(String key, String elPathSuffix) {
        pathBuilder.setElPathSuffix(key, elPathSuffix);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Example:</p>
     * <pre>
     *     TODO
     * </pre>
     *
     * @param key identify key
     * @param value value
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setTemplateValue(String key, String value) {
        pathBuilder.setTemplateValue(key, value);
        return (T) this;
    }

    /**
     * For customize template please see here: See http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#dpos
     * @param key   name template
     * @param value template
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setTemplate(String key, String value) {
        pathBuilder.setTemplate(key, value);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T addToTemplate(String key, String value) {
        pathBuilder.addToTemplate(key, value);
        return (T) this;
    }

    /**
     * <p><b><i>Used in logging process</i></b></p>
     *
     * @param infoMessage info Message
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setInfoMessage(final String infoMessage) {
        pathBuilder.setInfoMessage(infoMessage);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T setVisibility(final boolean visibility) {
        pathBuilder.setVisibility(visibility);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T setRenderMillis(final long renderMillis) {
       pathBuilder.setRenderMillis(renderMillis);
        return (T) this;
    }

    public <T extends WebLocatorAbstractBuilder> T setActivateSeconds(final int activateSeconds) {
        pathBuilder.setActivateSeconds(activateSeconds);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param container parent containing element.
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setContainer(WebLocator container) {
        pathBuilder.setContainer(container);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param label text label element
     * @param searchType type search text element: see more details see {@link SearchType}
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setLabel(String label, final SearchType... searchType) {
       pathBuilder.setLabel(label, searchType);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param labelTag label tag element
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setLabelTag(String labelTag) {
        pathBuilder.setLabelTag(labelTag);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     *
     * @param labelPosition position of this element reported to label
     * @param <T> the element which calls this method
     * @return this element
     * @see <a href="http://www.w3schools.com/xpath/xpath_axes.asp">http://www.w3schools.com/xpath/xpath_axes.asp"</a>
     */
    public <T extends WebLocatorAbstractBuilder> T setLabelPosition(String labelPosition) {
        pathBuilder.setLabelPosition(labelPosition);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Result Example:</p>
     * <pre>
     *     //*[contains(@class, 'x-grid-panel')][position() = 1]
     * </pre>
     *
     * @param position starting index = 1
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setPosition(int position) {
        pathBuilder.setPosition(position);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Result Example:</p>
     * <pre>
     *     //*[contains(@class, 'x-grid-panel')][position() = 1]
     * </pre>
     *
     * @param resultIdx starting index = 1
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setResultIdx(int resultIdx) {
        pathBuilder.setResultIdx(resultIdx);
        return (T) this;
    }

    /**
     * <p><b>Used for finding element process (to generate xpath address)</b></p>
     * <p>Result Example:</p>
     * <pre>
     *     //*[@type='type']
     * </pre>
     *
     * @param type eg. checkbox, button
     * @param <T> the element which calls this method
     * @return this element
     */
    public <T extends WebLocatorAbstractBuilder> T setType(String type) {
       pathBuilder.setType(type);
        return (T) this;
    }

    // =========================================
    // =============== Methods =================
    // =========================================

    /**
     * <p>Used only to identify class type of current object</p>
     * <p> Not used for css class!</p>
     */
    protected void setClassName(final String className) {
        pathBuilder.setClassName(className);
    }

    protected boolean hasId() {
        return pathBuilder.hasId();
    }

    protected boolean hasText() {
        return pathBuilder.hasText();
    }

    protected boolean hasLabel() {
        return pathBuilder.hasLabel();
    }

    protected boolean hasTitle() {
        return pathBuilder.hasTitle();
    }

    protected boolean hasPosition() {
        return pathBuilder.hasPosition();
    }

    protected boolean hasResultIdx() {
        return pathBuilder.hasResultIdx();
    }

    /**
     * @return final xpath (including containers xpath), used for interacting with browser
     */
    public final String getXPath() {
        return pathBuilder.getXPath();
    }

    /**
     * @deprecated use getXPath()
     */
    public final String getPath() {
        return getXPath();
    }

    public String getPath(boolean disabled) {
        return pathBuilder.getPath(disabled);
    }

    protected String applyTemplate(String key, Object... arguments) {
        return pathBuilder.applyTemplate(key, arguments);
    }
}