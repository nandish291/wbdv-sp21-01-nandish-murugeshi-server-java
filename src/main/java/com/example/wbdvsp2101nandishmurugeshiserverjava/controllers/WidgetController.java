package com.example.wbdvsp2101nandishmurugeshiserverjava.controllers;

import com.example.wbdvsp2101nandishmurugeshiserverjava.models.Widget;
import com.example.wbdvsp2101nandishmurugeshiserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    WidgetService service;

    public WidgetController(WidgetService service) {
        this.service = service;
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidgetForTopic(
            @PathVariable("tid") String topicId,
            @RequestBody Widget widget) {
        widget.setTopicId(topicId);
        return service.createWidgetForTopic(widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId
    ) {
        return service.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Long id) {
        return service.findWidgetById(id);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget(@PathVariable("wid") Long id) {
         service.deleteWidget(id);
         return 1;
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable("wid") Long id,
            @RequestBody Widget widget) {
        return service.updateWidget(id, widget);
    }
}
