package com.example.wbdvsp2101nandishmurugeshiserverjava.models;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private boolean ordered;
    private String text;
    private String url;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;
    private String topicId;



    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Widget(Long id, String name, String type, boolean ordered, String text, String url, Integer size,
                  Integer width, Integer height, String cssClass, String style, String value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.ordered = ordered;
        this.text = text;
        this.url = url;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
    }

    public Widget() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(boolean widgetOrder) {
        this.ordered = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getTopicId() {
        return topicId;
    }
}
