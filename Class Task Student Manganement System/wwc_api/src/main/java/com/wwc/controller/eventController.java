//package com.wwc.controller;
//import com.wwc.model.Event;
//import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;
//import java.util.List;
//@RestController
//@RequestMapping("/events")
//public class eventController {
//    private List<Event> events=new ArrayList<>();
//
//    @GetMapping
//    public List<Event> getAllEvents() {
//        return events;
//    }
//
//    @PostMapping
//    public String addEvent(@RequestBody Event event){
//        events.add(event);
//        return "Event added successfully";
//    }
//    @GetMapping("/events/id")
//    public Event getEventById(@RequestParam int id){
//
//        return events.stream().
//                filter(event->event.getId()==id).
//                findFirst().
//                orElse(null);
//    }
//    @DeleteMapping
//    public String deleteEventById(@RequestParam int id){
//        events.removeIf(event->event.getId() == id);
//        return "Event deleted successfully";
//    }
//
//}
