package com.example.wbdvsp2101nandishmurugeshiserverjava.services;

import com.example.wbdvsp2101nandishmurugeshiserverjava.models.Widget;
import com.example.wbdvsp2101nandishmurugeshiserverjava.repositories.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

    private final WidgetRepository repository;

    public WidgetService(WidgetRepository repository) {
        this.repository = repository;
    }

    private List<Widget> widgets = new ArrayList<Widget>();

    // implement crud operations
    public Widget createWidgetForTopic(Widget widget) {
        return repository.save(widget);
    }
    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
    }
    public List<Widget> findWidgetsForTopic(String topicId) {
//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(topicId)) {
//                ws.add(w);
//            }
//        }
        return repository.findAllByTopicId(topicId);
    }
    public Widget findWidgetById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Integer updateWidget(Long id, Widget newWidget) {
        Widget widget=findWidgetById(id);
        if(widget!=null)
        {
            repository.save(newWidget);
            return 1;
        }
        return -1;
    }
    public void deleteWidget(Long id) {
        repository.deleteById(id);
    }
}
