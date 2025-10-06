package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    // очистка всех задач
    public void clear() {
        items.clear();
    }

    // поиск задач по подстроке
    public List<String> search(String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String search = searchString.trim().toLowerCase();
        return items.stream()
                .filter(item -> item.toLowerCase().contains(search))
                .collect(Collectors.toList());
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}