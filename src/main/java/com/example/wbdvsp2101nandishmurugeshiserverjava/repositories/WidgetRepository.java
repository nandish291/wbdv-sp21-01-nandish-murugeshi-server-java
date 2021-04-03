package com.example.wbdvsp2101nandishmurugeshiserverjava.repositories;

import com.example.wbdvsp2101nandishmurugeshiserverjava.models.Widget;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget,Long> {

    List<Widget> findAllByTopicId(String id);
}
