package net.ericlefevre;

import java.util.*;

public class Day4Shifts {
    static class Event {
        int id;
        int month; int day; int hour; int minute; String type;

        @Override
        public String toString() {
            String t;
            if (type.equals("start")) {
                t = "Guard #" + id+" begins shift";
            } else {
                t = "Guard #" + id+" "+type ;
            }
            return "[1518-"+month+"-"+day+" "+hour+":"+minute+"] " + t;
        }
    }
    static Event event(int month, int day, int hour, int minute, String type) {
        Event e = new Event();
        e.id = 0;
        e.month = month;
        e.day = day;
        e.hour= hour;
        e.minute= minute;
        e.type= type;
        return e;
    }
    static Event event(int month, int day, int hour, int minute, int id) {
        Event e = new Event();
        e.id = id;
        e.month = month;
        e.day = day;
        e.hour= hour;
        e.minute= minute;
        e.type= "start";
        return e;
    }
    static Event[] events = new Event[]{event(5,31,0,27,"falls asleep"),event(4,15,0,54,"wakes up"),event(4,6,0,42,"falls asleep"),event(2,8,0,41,"wakes up"),event(11,11,0,59,"wakes up"),event(11,9,0,46,"wakes up"),event(6,15,0,29,"falls asleep"),event(5,25,0,44,"wakes up"),event(11,21,0,0,3203),event(8,28,0,4,1163),event(11,7,0,36,"wakes up"),event(4,22,0,16,"falls asleep"),event(7,19,0,31,"falls asleep"),event(5,4,23,48,1663),event(10,31,0,24,"falls asleep"),event(11,7,0,54,"wakes up"),event(6,18,0,4,859),event(6,26,0,38,"falls asleep"),event(7,12,0,46,"wakes up"),event(9,14,0,15,"wakes up"),event(9,3,0,47,"wakes up"),event(5,26,0,41,"wakes up"),event(3,17,0,56,"wakes up"),event(10,25,0,47,"falls asleep"),event(4,8,0,34,"falls asleep"),event(5,10,0,44,"falls asleep"),event(4,17,0,50,"wakes up"),event(6,29,0,39,"falls asleep"),event(4,19,0,59,"wakes up"),event(11,7,0,35,"falls asleep"),event(6,18,0,7,"falls asleep"),event(9,26,0,30,"falls asleep"),event(10,12,0,31,"falls asleep"),event(9,10,0,59,"wakes up"),event(7,27,0,53,"wakes up"),event(8,5,0,0,"falls asleep"),event(10,28,0,53,"wakes up"),event(5,19,0,0,997),event(6,27,0,50,"wakes up"),event(10,17,0,28,"falls asleep"),event(5,11,0,45,"wakes up"),event(3,18,0,7,"falls asleep"),event(4,3,0,50,"wakes up"),event(4,21,0,4,113),event(7,24,0,50,"wakes up"),event(9,13,0,41,"falls asleep"),event(6,19,0,30,"wakes up"),event(9,14,0,43,"falls asleep"),event(6,24,0,56,"wakes up"),event(7,12,0,28,"falls asleep"),event(4,21,0,33,"wakes up"),event(8,31,0,0,739),event(5,15,0,55,"wakes up"),event(6,9,0,39,"falls asleep"),event(3,12,0,3,997),event(4,15,0,16,"falls asleep"),event(9,7,0,26,"falls asleep"),event(3,26,0,21,"wakes up"),event(6,26,0,40,"wakes up"),event(2,5,0,2,1663),event(4,13,0,6,"falls asleep"),event(4,24,23,59,733),event(2,9,23,59,419),event(8,28,0,58,"wakes up"),event(3,16,0,58,"wakes up"),event(11,13,0,19,"falls asleep"),event(3,13,0,54,"wakes up"),event(4,12,0,46,"falls asleep"),event(3,4,0,17,"falls asleep"),event(4,10,0,40,"falls asleep"),event(5,11,0,1,1367),event(4,9,0,42,"wakes up"),event(3,29,0,53,"wakes up"),event(2,27,0,1,859),event(8,13,0,52,"falls asleep"),event(9,22,0,43,"falls asleep"),event(5,13,0,19,"falls asleep"),event(5,14,0,6,"falls asleep"),event(8,5,0,18,"wakes up"),event(11,10,0,41,"falls asleep"),event(9,10,0,43,"falls asleep"),event(3,2,0,44,"falls asleep"),event(4,16,23,57,1163),event(9,9,0,43,"falls asleep"),event(2,9,0,1,997),event(9,13,0,35,"falls asleep"),event(9,8,0,4,3407),event(8,2,0,14,"falls asleep"),event(11,7,0,2,2113),event(6,13,23,57,661),event(4,29,0,57,"wakes up"),event(11,4,0,56,"falls asleep"),event(8,3,0,54,"wakes up"),event(6,29,0,17,"falls asleep"),event(7,15,0,37,"wakes up"),event(6,14,23,58,2221),event(2,11,0,41,"falls asleep"),event(10,24,23,56,739),event(6,12,23,56,1663),event(2,23,23,51,2113),event(5,9,0,24,"falls asleep"),event(9,21,0,22,"wakes up"),event(2,11,0,38,"wakes up"),event(7,23,0,54,"falls asleep"),event(3,10,23,59,661),event(3,3,0,3,"falls asleep"),event(6,8,0,41,"wakes up"),event(2,5,0,12,"falls asleep"),event(9,23,0,51,"wakes up"),event(5,2,0,39,"wakes up"),event(7,6,0,6,"falls asleep"),event(3,27,23,57,2221),event(4,29,0,0,661),event(5,5,0,22,"wakes up"),event(9,12,0,38,"wakes up"),event(4,28,0,48,"falls asleep"),event(10,8,0,58,"wakes up"),event(8,22,0,55,"falls asleep"),event(10,22,0,52,"falls asleep"),event(7,15,0,56,"wakes up"),event(8,15,23,57,859),event(5,19,23,53,3407),event(11,3,0,3,2713),event(10,2,0,1,859),event(3,8,0,13,"falls asleep"),event(3,15,0,2,859),event(5,1,0,55,"wakes up"),event(7,25,0,41,"falls asleep"),event(5,24,0,24,"falls asleep"),event(5,3,0,58,"wakes up"),event(4,11,0,32,"falls asleep"),event(9,24,23,54,2383),event(10,24,0,23,"falls asleep"),event(6,24,0,28,"falls asleep"),event(8,4,0,59,"wakes up"),event(10,21,0,19,"wakes up"),event(3,21,0,4,661),event(6,18,0,15,"wakes up"),event(9,29,0,9,"falls asleep"),event(5,26,0,20,"falls asleep"),event(10,20,0,4,"falls asleep"),event(9,29,0,19,"wakes up"),event(8,10,0,3,"falls asleep"),event(8,3,0,3,"falls asleep"),event(7,14,0,41,"falls asleep"),event(9,26,0,13,"wakes up"),event(2,21,0,5,"falls asleep"),event(8,21,0,14,"falls asleep"),event(4,27,0,46,"wakes up"),event(6,11,23,57,3203),event(4,26,0,18,"wakes up"),event(2,24,0,2,"falls asleep"),event(9,13,0,21,"falls asleep"),event(7,6,0,18,"wakes up"),event(8,8,0,38,"falls asleep"),event(3,23,0,37,"falls asleep"),event(8,5,0,32,"falls asleep"),event(5,12,0,51,"falls asleep"),event(5,28,0,58,"wakes up"),event(2,15,0,24,"wakes up"),event(2,17,0,30,"falls asleep"),event(8,11,0,58,"wakes up"),event(4,26,0,9,"falls asleep"),event(6,20,0,58,"wakes up"),event(8,9,0,36,"falls asleep"),event(4,25,0,19,"wakes up"),event(2,28,0,58,"wakes up"),event(4,18,0,6,"falls asleep"),event(3,8,0,53,"wakes up"),event(9,13,0,36,"wakes up"),event(4,10,0,1,3391),event(11,15,0,48,"wakes up"),event(9,24,0,43,"wakes up"),event(5,15,0,14,"wakes up"),event(7,14,0,59,"wakes up"),event(6,28,23,57,733),event(9,13,0,25,"wakes up"),event(7,26,23,56,3203),event(5,28,0,47,"wakes up"),event(11,9,0,3,3391),event(7,1,0,52,"wakes up"),event(10,7,0,4,661),event(11,5,0,59,"wakes up"),event(6,15,0,45,"wakes up"),event(9,2,0,40,"wakes up"),event(6,5,0,0,419),event(2,4,0,57,"wakes up"),event(7,10,0,30,"falls asleep"),event(5,14,0,4,61),event(6,6,0,0,3203),event(11,22,0,4,2713),event(2,11,0,55,"wakes up"),event(8,15,0,47,"wakes up"),event(10,3,0,2,2383),event(6,2,0,57,"wakes up"),event(4,1,0,37,"wakes up"),event(6,29,23,58,859),event(11,22,0,38,"falls asleep"),event(4,13,0,0,2609),event(7,7,0,48,"wakes up"),event(10,29,0,54,"wakes up"),event(2,26,0,59,"wakes up"),event(10,18,0,4,1367),event(4,11,0,58,"wakes up"),event(10,27,23,59,1663),event(9,12,0,11,"falls asleep"),event(6,21,0,55,"wakes up"),event(6,16,0,0,2113),event(5,19,0,48,"wakes up"),event(8,31,0,23,"wakes up"),event(10,14,0,59,"wakes up"),event(2,17,0,4,2221),event(11,16,0,58,"wakes up"),event(7,8,0,31,"wakes up"),event(5,4,0,46,"falls asleep"),event(8,2,0,57,"wakes up"),event(3,25,0,0,3407),event(7,29,0,37,"falls asleep"),event(7,10,0,4,3203),event(7,26,0,32,"wakes up"),event(10,19,0,57,"falls asleep"),event(10,22,23,50,113),event(11,5,0,2,661),event(3,20,0,38,"falls asleep"),event(5,24,0,51,"wakes up"),event(3,7,0,32,"wakes up"),event(10,3,0,45,"falls asleep"),event(8,15,0,1,859),event(10,29,0,3,2221),event(11,12,0,0,"falls asleep"),event(11,22,23,58,733),event(6,18,0,42,"falls asleep"),event(10,18,0,58,"wakes up"),event(2,19,0,0,419),event(3,26,0,19,"falls asleep"),event(3,14,0,49,"falls asleep"),event(9,5,23,47,419),event(9,3,0,57,"falls asleep"),event(8,6,0,0,661),event(9,24,0,41,"falls asleep"),event(9,15,0,55,"wakes up"),event(10,15,0,50,"wakes up"),event(5,28,0,35,"falls asleep"),event(2,11,0,32,"falls asleep"),event(6,19,0,36,"falls asleep"),event(2,25,0,6,"falls asleep"),event(4,20,0,50,"wakes up"),event(2,17,0,54,"wakes up"),event(5,29,0,0,2609),event(7,26,0,0,2383),event(8,14,0,11,"falls asleep"),event(8,1,0,0,2297),event(4,4,0,41,"wakes up"),event(6,10,0,55,"wakes up"),event(3,19,0,5,"falls asleep"),event(6,11,0,30,"falls asleep"),event(3,31,0,20,"falls asleep"),event(7,13,0,52,"wakes up"),event(8,29,0,11,"falls asleep"),event(5,16,0,42,"wakes up"),event(11,5,0,36,"wakes up"),event(10,22,0,40,"wakes up"),event(9,6,0,1,"falls asleep"),event(9,20,0,42,"falls asleep"),event(11,7,0,48,"falls asleep"),event(7,31,0,59,"wakes up"),event(4,19,0,30,"wakes up"),event(5,12,23,56,997),event(3,4,0,53,"wakes up"),event(10,7,0,6,"falls asleep"),event(8,28,0,27,"falls asleep"),event(5,16,0,17,"falls asleep"),event(10,23,0,4,"falls asleep"),event(7,8,0,57,"wakes up"),event(6,14,0,50,"wakes up"),event(4,13,0,46,"wakes up"),event(4,5,23,50,419),event(10,25,0,43,"wakes up"),event(4,8,0,18,"wakes up"),event(5,12,0,29,"wakes up"),event(3,28,23,56,2609),event(9,13,0,56,"wakes up"),event(3,8,0,48,"falls asleep"),event(2,12,0,32,"falls asleep"),event(10,15,0,2,2297),event(7,26,0,38,"falls asleep"),event(4,6,23,47,2383),event(10,3,0,40,"wakes up"),event(7,23,0,58,"wakes up"),event(3,17,0,2,1367),event(6,30,0,47,"falls asleep"),event(9,6,0,24,"falls asleep"),event(5,4,0,54,"wakes up"),event(4,19,0,39,"wakes up"),event(7,15,0,10,"falls asleep"),event(7,26,0,28,"falls asleep"),event(7,21,0,24,"falls asleep"),event(8,9,23,54,739),event(2,21,0,45,"falls asleep"),event(3,10,0,53,"wakes up"),event(6,13,0,9,"falls asleep"),event(8,6,0,47,"falls asleep"),event(10,31,0,53,"wakes up"),event(8,23,23,51,739),event(3,13,0,3,3203),event(6,2,0,14,"falls asleep"),event(10,20,0,38,"falls asleep"),event(8,25,0,43,"falls asleep"),event(8,31,23,53,733),event(4,30,0,17,"falls asleep"),event(8,6,0,12,"falls asleep"),event(11,6,0,2,739),event(7,2,0,56,"wakes up"),event(5,29,0,18,"falls asleep"),event(2,14,0,57,"wakes up"),event(3,13,0,52,"falls asleep"),event(9,26,23,49,2713),event(5,19,0,37,"falls asleep"),event(8,30,0,26,"falls asleep"),event(5,30,0,8,"falls asleep"),event(9,1,0,54,"wakes up"),event(11,4,0,47,"wakes up"),event(6,4,0,26,"wakes up"),event(8,10,0,48,"falls asleep"),event(4,11,0,2,2221),event(7,11,23,57,61),event(7,20,0,45,"wakes up"),event(4,3,23,59,3391),event(11,8,0,56,"wakes up"),event(8,4,0,56,"falls asleep"),event(9,19,0,43,"wakes up"),event(2,12,0,0,61),event(7,6,23,50,661),event(6,7,0,20,"falls asleep"),event(8,8,0,2,997),event(7,21,0,47,"wakes up"),event(11,15,0,2,1163),event(4,30,0,58,"wakes up"),event(8,6,0,19,"wakes up"),event(3,8,23,50,61),event(7,8,23,59,2609),event(8,22,0,1,2383),event(6,30,0,55,"wakes up"),event(6,19,0,25,"falls asleep"),event(5,5,0,3,"falls asleep"),event(9,12,23,56,2609),event(7,3,0,43,"wakes up"),event(7,18,0,25,"wakes up"),event(7,16,23,57,941),event(11,21,0,20,"falls asleep"),event(11,4,0,59,"wakes up"),event(7,27,0,31,"falls asleep"),event(10,12,0,43,"falls asleep"),event(3,22,0,4,997),event(3,5,0,3,1663),event(6,27,0,53,"falls asleep"),event(8,22,0,45,"falls asleep"),event(7,8,0,0,1367),event(6,1,0,14,"falls asleep"),event(2,25,0,1,1163),event(9,22,0,15,"falls asleep"),event(5,3,0,3,"falls asleep"),event(9,22,0,2,"falls asleep"),event(9,21,0,54,"wakes up"),event(6,21,0,0,859),event(6,28,0,59,"wakes up"),event(3,19,0,21,"wakes up"),event(8,31,0,38,"wakes up"),event(9,26,0,49,"wakes up"),event(11,19,0,36,"wakes up"),event(2,28,0,2,3391),event(2,12,0,58,"wakes up"),event(11,8,0,31,"falls asleep"),event(4,17,0,41,"falls asleep"),event(10,11,0,2,2113),event(8,3,0,41,"falls asleep"),event(6,13,0,43,"falls asleep"),event(3,28,0,50,"falls asleep"),event(10,21,0,53,"wakes up"),event(4,21,0,48,"falls asleep"),event(2,16,0,56,"wakes up"),event(3,9,0,27,"falls asleep"),event(8,4,0,13,"falls asleep"),event(2,17,0,47,"falls asleep"),event(6,10,23,57,1163),event(10,11,0,49,"falls asleep"),event(8,1,0,17,"wakes up"),event(2,20,23,52,3407),event(3,9,0,0,"falls asleep"),event(10,21,23,46,661),event(2,19,0,29,"falls asleep"),event(8,23,0,36,"falls asleep"),event(6,16,0,11,"falls asleep"),event(8,26,0,52,"wakes up"),event(8,7,0,43,"falls asleep"),event(11,7,23,59,997),event(11,18,0,10,"falls asleep"),event(7,23,0,34,"falls asleep"),event(3,30,0,59,"wakes up"),event(3,29,0,48,"falls asleep"),event(9,20,23,50,419),event(6,6,23,57,1663),event(8,13,0,0,2113),event(4,28,0,4,739),event(9,11,0,34,"falls asleep"),event(6,18,0,28,"falls asleep"),event(5,21,0,7,"falls asleep"),event(8,25,0,40,"wakes up"),event(8,20,0,48,"falls asleep"),event(9,30,0,0,3391),event(8,2,0,56,"falls asleep"),event(8,13,0,57,"wakes up"),event(5,23,0,0,739),event(5,4,0,38,"wakes up"),event(8,4,0,45,"wakes up"),event(2,15,0,0,3391),event(8,13,23,58,1663),event(6,4,0,55,"wakes up"),event(4,8,0,4,"falls asleep"),event(6,28,0,57,"falls asleep"),event(8,9,0,44,"wakes up"),event(6,25,0,38,"wakes up"),event(3,3,0,48,"falls asleep"),event(5,2,0,43,"falls asleep"),event(10,10,0,51,"falls asleep"),event(11,4,0,43,"falls asleep"),event(8,10,0,45,"wakes up"),event(9,27,0,58,"wakes up"),event(4,17,23,58,3203),event(7,4,0,34,"falls asleep"),event(3,14,0,42,"wakes up"),event(10,12,0,39,"wakes up"),event(8,16,0,49,"wakes up"),event(10,19,23,54,997),event(5,17,0,0,2383),event(3,3,0,54,"wakes up"),event(9,27,0,57,"falls asleep"),event(3,30,0,41,"falls asleep"),event(11,6,0,57,"wakes up"),event(9,14,0,0,"falls asleep"),event(9,28,0,16,"falls asleep"),event(9,14,0,44,"wakes up"),event(5,8,23,58,1163),event(9,12,0,2,859),event(8,11,0,15,"falls asleep"),event(10,9,23,56,2221),event(5,1,23,53,733),event(7,19,0,52,"wakes up"),event(11,22,0,59,"wakes up"),event(11,23,0,28,"falls asleep"),event(8,15,0,37,"falls asleep"),event(5,2,0,52,"wakes up"),event(6,25,23,58,2609),event(7,6,0,16,"falls asleep"),event(5,30,0,3,997),event(3,6,0,20,"falls asleep"),event(9,22,0,51,"wakes up"),event(11,8,0,42,"wakes up"),event(7,24,23,56,739),event(6,11,0,37,"wakes up"),event(4,15,0,49,"falls asleep"),event(7,26,0,57,"wakes up"),event(2,19,23,50,2221),event(5,3,0,29,"wakes up"),event(4,15,0,36,"wakes up"),event(3,26,0,4,1163),event(10,18,0,15,"falls asleep"),event(4,23,23,59,3391),event(6,28,0,35,"wakes up"),event(5,4,0,37,"falls asleep"),event(10,14,0,0,997),event(7,18,0,44,"wakes up"),event(4,3,0,4,"falls asleep"),event(4,13,0,36,"wakes up"),event(6,9,0,1,739),event(3,13,0,38,"falls asleep"),event(6,8,0,57,"falls asleep"),event(4,21,0,10,"falls asleep"),event(8,4,0,4,859),event(3,2,0,58,"wakes up"),event(6,15,0,34,"wakes up"),event(2,6,0,50,"wakes up"),event(11,20,0,43,"wakes up"),event(11,15,23,57,859),event(7,26,0,23,"wakes up"),event(5,24,0,2,3391),event(7,18,0,22,"falls asleep"),event(4,25,0,31,"falls asleep"),event(8,27,0,49,"falls asleep"),event(7,21,23,58,349),event(6,10,0,54,"falls asleep"),event(9,17,0,4,733),event(6,20,0,39,"falls asleep"),event(3,23,0,1,2297),event(5,21,0,59,"wakes up"),event(9,24,0,17,"falls asleep"),event(6,23,0,12,"falls asleep"),event(5,20,0,3,"falls asleep"),event(9,26,0,3,"falls asleep"),event(5,31,0,37,"falls asleep"),event(6,30,23,59,739),event(7,7,0,5,"falls asleep"),event(4,19,0,17,"falls asleep"),event(3,13,0,44,"wakes up"),event(9,3,0,0,661),event(2,15,23,49,739),event(4,7,0,5,"falls asleep"),event(2,26,0,1,661),event(11,17,23,57,859),event(8,22,0,47,"wakes up"),event(9,23,0,16,"falls asleep"),event(7,21,0,40,"falls asleep"),event(3,31,0,0,1663),event(8,1,0,10,"falls asleep"),event(9,30,0,52,"wakes up"),event(4,14,0,8,"falls asleep"),event(2,6,23,56,859),event(4,16,0,27,"wakes up"),event(5,22,0,29,"falls asleep"),event(11,1,0,31,"falls asleep"),event(9,28,0,39,"wakes up"),event(5,22,0,30,"wakes up"),event(10,3,0,55,"wakes up"),event(6,21,23,56,907),event(5,28,0,57,"falls asleep"),event(6,6,0,40,"falls asleep"),event(8,23,0,59,"wakes up"),event(5,20,0,47,"wakes up"),event(3,12,0,31,"falls asleep"),event(7,12,0,56,"wakes up"),event(8,3,0,25,"wakes up"),event(5,8,0,4,419),event(10,9,0,0,419),event(10,30,0,4,733),event(2,9,0,37,"falls asleep"),event(3,17,23,59,2297),event(2,21,0,8,"wakes up"),event(5,10,0,47,"wakes up"),event(11,20,0,1,"falls asleep"),event(7,6,0,2,113),event(6,14,0,34,"falls asleep"),event(9,11,0,39,"wakes up"),event(5,27,0,27,"wakes up"),event(4,7,0,36,"wakes up"),event(3,27,0,3,907),event(7,18,0,42,"falls asleep"),event(11,17,0,0,3407),event(4,11,0,6,"falls asleep"),event(6,7,0,59,"wakes up"),event(5,4,0,1,1663),event(5,3,0,47,"wakes up"),event(10,6,0,51,"wakes up"),event(3,12,0,57,"wakes up"),event(3,23,0,23,"falls asleep"),event(3,2,23,48,3391),event(5,14,23,52,733),event(8,15,0,55,"wakes up"),event(8,14,0,54,"wakes up"),event(6,8,0,30,"falls asleep"),event(2,18,0,58,"wakes up"),event(11,3,0,58,"wakes up"),event(6,17,0,0,2221),event(4,5,0,14,"falls asleep"),event(8,29,0,1,"falls asleep"),event(5,14,0,13,"wakes up"),event(10,25,0,50,"wakes up"),event(6,24,0,3,739),event(10,26,0,54,"wakes up"),event(8,17,0,14,"falls asleep"),event(10,4,0,3,3407),event(6,5,0,30,"wakes up"),event(6,9,23,59,2221),event(9,19,0,59,"wakes up"),event(10,5,23,56,3203),event(5,2,0,3,"falls asleep"),event(9,25,0,3,"falls asleep"),event(9,11,0,42,"falls asleep"),event(7,8,0,8,"falls asleep"),event(5,7,0,58,"wakes up"),event(7,24,0,58,"wakes up"),event(4,12,0,21,"wakes up"),event(10,29,0,29,"falls asleep"),event(7,28,23,56,3391),event(7,16,0,23,"falls asleep"),event(6,4,0,0,2713),event(8,29,0,7,"wakes up"),event(8,31,0,46,"falls asleep"),event(3,14,0,54,"wakes up"),event(9,29,0,4,2383),event(8,7,0,56,"wakes up"),event(6,2,0,56,"falls asleep"),event(3,12,0,19,"wakes up"),event(4,28,0,52,"wakes up"),event(7,13,0,58,"wakes up"),event(4,8,23,57,3203),event(4,5,0,49,"wakes up"),event(7,3,0,22,"falls asleep"),event(2,12,0,53,"wakes up"),event(9,24,0,3,733),event(7,30,0,1,1163),event(3,16,0,0,739),event(8,18,0,50,"wakes up"),event(3,22,0,57,"wakes up"),event(6,2,0,4,3391),event(9,1,0,2,"falls asleep"),event(9,11,0,49,"wakes up"),event(4,13,0,41,"falls asleep"),event(4,18,0,53,"wakes up"),event(3,21,0,38,"wakes up"),event(6,2,0,52,"wakes up"),event(7,18,23,59,733),event(6,25,0,59,"wakes up"),event(4,7,23,54,2713),event(6,28,0,14,"falls asleep"),event(3,4,0,4,1663),event(5,27,0,4,"falls asleep"),event(10,8,0,31,"falls asleep"),event(11,5,0,16,"falls asleep"),event(5,14,0,53,"falls asleep"),event(10,4,0,47,"wakes up"),event(9,7,0,11,"falls asleep"),event(9,25,23,48,2297),event(10,26,0,0,1663),event(3,11,0,56,"wakes up"),event(8,28,23,49,1663),event(8,31,0,47,"wakes up"),event(9,4,0,52,"falls asleep"),event(11,16,0,38,"falls asleep"),event(10,19,0,59,"wakes up"),event(10,19,0,23,"falls asleep"),event(5,1,0,23,"falls asleep"),event(5,15,23,56,3391),event(7,1,0,7,"falls asleep"),event(7,30,0,52,"falls asleep"),event(5,12,0,27,"falls asleep"),event(4,4,0,7,"falls asleep"),event(6,9,0,58,"wakes up"),event(2,28,0,16,"falls asleep"),event(9,5,0,30,"falls asleep"),event(5,6,0,52,"falls asleep"),event(10,21,0,2,733),event(7,30,0,56,"wakes up"),event(9,30,0,13,"falls asleep"),event(10,16,23,58,997),event(5,26,0,3,61),event(6,8,0,25,"wakes up"),event(7,11,0,1,1367),event(7,15,0,2,61),event(10,26,0,50,"falls asleep"),event(5,26,0,45,"falls asleep"),event(7,16,0,0,739),event(9,18,0,4,3407),event(3,22,0,53,"falls asleep"),event(6,25,0,16,"falls asleep"),event(6,27,23,59,2609),event(9,16,0,41,"falls asleep"),event(8,20,0,58,"wakes up"),event(2,13,0,2,3407),event(2,23,0,50,"wakes up"),event(5,28,0,0,61),event(4,6,0,39,"wakes up"),event(11,21,0,42,"wakes up"),event(7,6,0,12,"wakes up"),event(8,11,0,0,2297),event(6,4,0,18,"falls asleep"),event(9,7,0,49,"wakes up"),event(6,27,0,56,"wakes up"),event(9,25,0,38,"wakes up"),event(4,6,0,19,"wakes up"),event(9,21,0,2,"falls asleep"),event(3,15,0,38,"wakes up"),event(11,10,0,0,2297),event(8,31,0,14,"falls asleep"),event(2,9,0,38,"wakes up"),event(10,22,0,1,"falls asleep"),event(6,11,0,52,"wakes up"),event(4,20,0,39,"falls asleep"),event(4,8,0,57,"wakes up"),event(5,17,23,50,733),event(2,10,0,47,"wakes up"),event(9,23,0,0,1163),event(10,4,0,22,"falls asleep"),event(2,8,0,9,"falls asleep"),event(10,16,0,44,"falls asleep"),event(7,1,23,59,1367),event(10,16,0,50,"wakes up"),event(5,15,0,17,"falls asleep"),event(7,30,0,40,"wakes up"),event(10,16,0,28,"falls asleep"),event(4,6,0,37,"falls asleep"),event(3,8,0,23,"wakes up"),event(6,4,0,54,"falls asleep"),event(9,12,0,45,"wakes up"),event(3,15,0,12,"falls asleep"),event(5,23,0,22,"falls asleep"),event(7,28,0,0,907),event(8,22,0,56,"wakes up"),event(8,24,0,33,"falls asleep"),event(4,22,0,0,739),event(2,13,23,57,1367),event(7,9,0,49,"falls asleep"),event(10,9,0,20,"falls asleep"),event(4,1,23,56,941),event(10,16,0,0,113),event(9,21,0,34,"falls asleep"),event(7,23,0,35,"wakes up"),event(3,1,0,12,"falls asleep"),event(2,3,23,50,661),event(9,9,0,56,"wakes up"),event(3,7,0,22,"falls asleep"),event(8,21,0,53,"wakes up"),event(9,4,0,1,2297),event(8,10,0,58,"wakes up"),event(7,3,23,56,3407),event(8,26,0,42,"falls asleep"),event(11,13,23,56,907),event(10,15,0,16,"falls asleep"),event(8,16,0,44,"falls asleep"),event(7,18,0,1,2609),event(10,20,0,22,"wakes up"),event(10,24,0,1,2609),event(4,28,0,55,"falls asleep"),event(2,11,0,0,1367),event(6,19,0,39,"wakes up"),event(9,27,0,4,"falls asleep"),event(4,19,0,46,"falls asleep"),event(8,10,0,31,"falls asleep"),event(9,21,23,48,2713),event(9,10,23,57,997),event(10,13,0,55,"falls asleep"),event(8,20,23,59,3203),event(6,27,0,33,"falls asleep"),event(5,10,0,0,739),event(8,30,0,0,2609),event(9,5,0,24,"wakes up"),event(9,11,0,58,"wakes up"),event(7,8,0,39,"falls asleep"),event(8,22,0,20,"wakes up"),event(7,29,0,43,"wakes up"),event(8,22,0,14,"falls asleep"),event(8,2,0,53,"wakes up"),event(11,17,0,24,"falls asleep"),event(3,25,0,11,"falls asleep"),event(3,6,0,48,"wakes up"),event(9,12,0,43,"falls asleep"),event(10,20,0,57,"wakes up"),event(4,4,23,57,733),event(9,3,0,58,"wakes up"),event(9,16,0,59,"wakes up"),event(7,23,0,0,2113),event(9,4,0,59,"wakes up"),event(9,11,0,53,"falls asleep"),event(4,8,0,54,"falls asleep"),event(8,7,0,3,859),event(8,4,23,49,2297),event(5,23,0,51,"wakes up"),event(11,1,23,58,907),event(2,5,23,56,419),event(8,17,0,1,3391),event(9,27,23,58,3391),event(3,16,0,35,"falls asleep"),event(8,17,23,57,113),event(2,7,0,44,"wakes up"),event(8,18,0,24,"falls asleep"),event(11,1,0,0,661),event(10,19,0,39,"wakes up"),event(8,24,23,59,997),event(5,18,0,4,"falls asleep"),event(3,17,0,30,"falls asleep"),event(4,8,0,51,"wakes up"),event(8,24,0,53,"wakes up"),event(9,22,0,3,"wakes up"),event(6,8,0,59,"wakes up"),event(4,10,0,56,"wakes up"),event(5,22,0,1,2383),event(6,1,0,0,661),event(8,22,23,58,997),event(3,22,0,42,"wakes up"),event(10,21,0,51,"falls asleep"),event(11,11,23,48,997),event(5,1,0,0,1163),event(5,20,23,56,3203),event(10,4,0,37,"falls asleep"),event(8,24,0,0,"falls asleep"),event(9,18,0,25,"falls asleep"),event(10,13,0,49,"wakes up"),event(11,23,0,53,"wakes up"),event(4,20,0,0,"falls asleep"),event(10,6,0,12,"falls asleep"),event(8,27,0,42,"wakes up"),event(9,24,0,54,"falls asleep"),event(6,25,0,0,2713),event(7,30,0,29,"falls asleep"),event(10,13,0,10,"falls asleep"),event(9,22,0,18,"wakes up"),event(3,6,0,0,2113),event(5,17,0,22,"falls asleep"),event(2,17,23,50,2297),event(4,24,0,26,"falls asleep"),event(7,26,0,21,"falls asleep"),event(3,25,0,27,"wakes up"),event(6,7,0,52,"falls asleep"),event(4,16,0,23,"falls asleep"),event(11,1,0,41,"wakes up"),event(6,29,0,23,"wakes up"),event(8,1,0,40,"wakes up"),event(7,6,0,42,"wakes up"),event(8,13,0,18,"falls asleep"),event(6,13,0,50,"wakes up"),event(9,15,0,38,"falls asleep"),event(10,5,0,46,"falls asleep"),event(10,5,0,0,3407),event(6,1,0,55,"wakes up"),event(9,4,0,35,"falls asleep"),event(9,24,0,59,"wakes up"),event(9,24,0,33,"wakes up"),event(2,4,0,1,"falls asleep"),event(2,23,0,7,"falls asleep"),event(5,3,0,38,"falls asleep"),event(9,17,0,49,"wakes up"),event(3,20,0,52,"wakes up"),event(8,19,0,55,"falls asleep"),event(4,6,0,56,"wakes up"),event(5,30,0,56,"wakes up"),event(9,13,23,47,1663),event(4,12,0,50,"wakes up"),event(6,8,0,4,1663),event(4,12,0,9,"falls asleep"),event(5,31,0,34,"wakes up"),event(2,7,0,8,"falls asleep"),event(9,2,0,22,"falls asleep"),event(9,18,0,53,"wakes up"),event(7,11,0,13,"falls asleep"),event(4,25,0,56,"wakes up"),event(4,19,23,50,739),event(3,12,0,18,"falls asleep"),event(8,7,0,45,"wakes up"),event(3,14,0,29,"falls asleep"),event(10,30,0,45,"falls asleep"),event(6,20,0,0,997),event(6,21,0,7,"falls asleep"),event(3,5,0,13,"falls asleep"),event(4,15,23,58,2383),event(10,27,0,25,"falls asleep"),event(6,23,0,51,"wakes up"),event(7,21,0,0,2221),event(10,1,0,33,"wakes up"),event(4,24,0,44,"wakes up"),event(3,21,0,27,"falls asleep"),event(2,22,0,8,"falls asleep"),event(10,5,0,47,"wakes up"),event(3,23,0,40,"wakes up"),event(11,19,0,15,"falls asleep"),event(2,21,23,57,2297),event(9,8,0,40,"wakes up"),event(11,5,0,47,"falls asleep"),event(2,24,0,59,"wakes up"),event(11,6,0,12,"falls asleep"),event(10,28,0,23,"falls asleep"),event(9,20,0,4,2713),event(11,15,0,33,"falls asleep"),event(9,5,0,50,"wakes up"),event(6,17,0,59,"wakes up"),event(6,8,0,8,"wakes up"),event(2,18,0,4,"falls asleep"),event(8,13,0,41,"wakes up"),event(9,19,0,21,"falls asleep"),event(11,13,0,58,"wakes up"),event(8,31,0,36,"falls asleep"),event(7,2,0,53,"falls asleep"),event(8,23,0,41,"wakes up"),event(9,14,23,57,2713),event(7,24,0,44,"falls asleep"),event(2,13,0,51,"wakes up"),event(6,18,23,59,61),event(8,2,0,3,1367),event(6,15,0,38,"falls asleep"),event(10,1,0,2,"falls asleep"),event(10,16,0,39,"wakes up"),event(10,11,0,50,"wakes up"),event(7,2,0,25,"falls asleep"),event(2,17,0,39,"wakes up"),event(7,11,0,20,"wakes up"),event(6,23,0,4,1367),event(11,11,0,27,"falls asleep"),event(10,18,0,47,"wakes up"),event(3,10,0,1,997),event(5,30,23,56,997),event(7,9,0,24,"falls asleep"),event(2,28,23,57,859),event(5,8,0,29,"wakes up"),event(3,8,0,41,"wakes up"),event(8,25,0,57,"wakes up"),event(11,3,0,56,"falls asleep"),event(5,6,0,1,733),event(11,19,23,50,3203),event(6,3,0,56,"wakes up"),event(10,18,0,57,"falls asleep"),event(11,15,0,16,"wakes up"),event(7,12,0,54,"falls asleep"),event(9,19,0,57,"falls asleep"),event(3,31,0,58,"wakes up"),event(5,18,0,57,"wakes up"),event(10,19,0,3,419),event(4,25,0,42,"falls asleep"),event(11,10,0,59,"wakes up"),event(5,14,0,57,"wakes up"),event(7,31,0,16,"falls asleep"),event(11,4,0,2,1367),event(7,2,23,59,661),event(6,27,0,4,661),event(2,6,0,18,"falls asleep"),event(4,29,0,37,"falls asleep"),event(5,29,0,40,"wakes up"),event(8,25,0,35,"falls asleep"),event(6,12,0,29,"wakes up"),event(8,9,0,2,2297),event(6,25,0,53,"falls asleep"),event(3,29,0,42,"wakes up"),event(3,22,0,37,"falls asleep"),event(2,14,0,34,"wakes up"),event(2,12,0,52,"falls asleep"),event(8,6,0,53,"wakes up"),event(9,2,0,0,3407),event(10,2,0,34,"wakes up"),event(10,27,0,1,1663),event(9,16,0,1,859),event(10,7,0,34,"wakes up"),event(3,5,0,48,"wakes up"),event(3,24,0,21,"falls asleep"),event(3,10,0,24,"falls asleep"),event(10,3,0,23,"falls asleep"),event(11,3,0,49,"wakes up"),event(7,15,0,53,"falls asleep"),event(10,9,0,35,"wakes up"),event(10,12,0,49,"wakes up"),event(3,1,23,57,3407),event(6,5,0,46,"falls asleep"),event(5,2,23,50,1163),event(4,6,0,1,"falls asleep"),event(7,5,0,40,"wakes up"),event(5,26,23,53,113),event(10,24,0,51,"wakes up"),event(10,29,0,9,"falls asleep"),event(3,7,23,57,859),event(6,7,0,45,"wakes up"),event(3,1,0,16,"wakes up"),event(6,16,0,41,"falls asleep"),event(4,19,0,37,"falls asleep"),event(4,25,0,11,"falls asleep"),event(3,19,23,57,733),event(11,15,0,13,"falls asleep"),event(10,13,0,0,733),event(2,20,0,3,"falls asleep"),event(9,8,0,26,"falls asleep"),event(7,25,0,58,"wakes up"),event(4,23,0,3,349),event(6,11,0,51,"falls asleep"),event(5,11,0,53,"falls asleep"),event(2,20,0,11,"wakes up"),event(10,29,0,16,"wakes up"),event(8,17,0,55,"wakes up"),event(8,1,0,35,"falls asleep"),event(5,26,0,52,"wakes up"),event(11,18,0,55,"wakes up"),event(2,12,0,57,"falls asleep"),event(2,15,0,12,"falls asleep"),event(9,6,0,44,"wakes up"),event(3,18,23,48,1163),event(10,1,0,42,"falls asleep"),event(2,26,0,12,"falls asleep"),event(3,28,0,56,"wakes up"),event(6,6,0,46,"wakes up"),event(10,10,0,54,"wakes up"),event(11,18,23,59,419),event(10,21,0,7,"falls asleep"),event(3,13,0,34,"wakes up"),event(4,21,0,55,"wakes up"),event(9,7,0,23,"wakes up"),event(3,9,0,46,"wakes up"),event(3,29,0,8,"falls asleep"),event(5,11,0,42,"falls asleep"),event(8,12,0,41,"wakes up"),event(8,5,0,39,"wakes up"),event(7,19,23,56,3391),event(10,8,0,3,1367),event(5,8,0,26,"falls asleep"),event(2,5,0,53,"wakes up"),event(3,11,0,10,"falls asleep"),event(5,6,0,59,"wakes up"),event(3,23,0,32,"wakes up"),event(8,19,0,59,"wakes up"),event(7,2,0,35,"wakes up"),event(10,4,0,33,"wakes up"),event(4,26,0,26,"falls asleep"),event(4,27,0,45,"falls asleep"),event(2,19,0,37,"wakes up"),event(7,12,23,58,2297),event(9,19,0,2,1663),event(8,23,0,47,"falls asleep"),event(3,3,0,28,"wakes up"),event(5,13,0,43,"wakes up"),event(9,10,0,4,859),event(9,27,0,28,"wakes up"),event(4,11,23,56,739),event(4,11,0,11,"wakes up"),event(5,31,0,44,"wakes up"),event(6,8,0,7,"falls asleep"),event(9,6,0,19,"wakes up"),event(8,2,23,50,419),event(8,8,0,54,"wakes up"),event(8,19,0,6,"falls asleep"),event(10,14,0,57,"falls asleep"),event(8,27,0,1,"falls asleep"),event(8,24,0,7,"wakes up"),event(4,26,0,3,419),event(8,27,0,58,"wakes up"),event(7,9,0,45,"wakes up"),event(7,20,0,18,"falls asleep"),event(7,6,0,38,"falls asleep"),event(4,22,0,39,"wakes up"),event(5,11,0,58,"wakes up"),event(7,4,0,50,"wakes up"),event(9,9,0,1,733),event(7,9,0,54,"wakes up"),event(10,30,23,56,733),event(11,13,0,0,3407),event(4,27,0,0,739),event(8,29,0,59,"wakes up"),event(10,14,0,43,"wakes up"),event(3,24,0,41,"wakes up"),event(6,5,0,34,"falls asleep"),event(5,7,0,37,"falls asleep"),event(4,13,23,57,733),event(4,30,0,3,733),event(7,5,0,1,419),event(10,26,0,31,"falls asleep"),event(8,12,0,15,"falls asleep"),event(11,8,0,54,"falls asleep"),event(3,6,23,59,997),event(6,18,0,55,"wakes up"),event(11,9,0,21,"falls asleep"),event(4,2,23,51,2113),event(6,5,0,57,"wakes up"),event(8,11,23,57,997),event(6,18,0,39,"wakes up"),event(11,12,0,46,"wakes up"),event(6,3,0,46,"falls asleep"),event(8,30,0,48,"wakes up"),event(6,2,23,58,859),event(7,13,0,56,"falls asleep"),event(11,3,0,36,"falls asleep"),event(2,12,0,39,"wakes up"),event(4,9,0,14,"falls asleep"),event(7,10,0,34,"wakes up"),event(6,8,0,18,"falls asleep"),event(9,4,23,58,1663),event(5,12,0,52,"wakes up"),event(9,30,23,48,3407),event(8,10,0,17,"wakes up"),event(3,29,23,56,2221),event(6,29,0,55,"wakes up"),event(9,10,0,57,"falls asleep"),event(4,1,0,2,"falls asleep"),event(7,13,0,34,"falls asleep"),event(6,17,0,15,"falls asleep"),event(4,19,0,0,997),event(10,13,0,59,"wakes up"),event(10,26,0,46,"wakes up"),event(2,21,0,56,"wakes up"),event(4,25,0,37,"wakes up"),event(3,24,0,2,113),event(4,26,0,49,"wakes up"),event(3,18,0,50,"wakes up"),event(3,8,0,37,"falls asleep"),event(8,15,0,50,"falls asleep"),event(3,25,0,42,"wakes up"),event(2,14,0,37,"falls asleep"),event(11,10,23,58,2221),event(6,5,0,40,"wakes up"),event(7,21,0,34,"wakes up"),event(10,1,0,51,"wakes up"),event(9,17,0,48,"falls asleep"),event(5,17,0,54,"wakes up"),event(2,27,0,47,"wakes up"),event(9,3,0,19,"falls asleep"),event(6,16,0,58,"wakes up"),event(2,10,0,16,"falls asleep"),event(5,9,0,55,"wakes up"),event(7,31,0,1,1367),event(9,5,0,11,"falls asleep"),event(2,25,0,51,"wakes up"),event(6,16,0,20,"wakes up"),event(4,20,0,1,"wakes up"),event(7,16,0,59,"wakes up"),event(10,22,0,53,"wakes up"),event(7,5,0,21,"falls asleep"),event(8,26,23,47,3407),event(9,6,23,59,2297),event(5,12,0,0,113),event(6,13,0,35,"wakes up"),event(7,24,0,4,2221),event(2,16,0,4,"falls asleep"),event(9,20,0,57,"wakes up"),event(10,25,0,38,"falls asleep"),event(3,13,0,18,"falls asleep"),event(5,25,0,26,"falls asleep"),event(2,22,0,53,"wakes up"),event(3,28,0,42,"wakes up"),event(2,23,0,4,419),event(3,13,23,59,3407),event(10,2,0,32,"falls asleep"),event(5,3,0,50,"falls asleep"),event(10,27,0,54,"wakes up"),event(2,8,0,0,2383),event(3,25,0,35,"falls asleep"),event(8,19,0,40,"wakes up"),event(8,7,0,53,"falls asleep"),event(2,14,0,31,"falls asleep"),event(8,26,0,4,2383),event(4,15,0,3,661),event(2,27,0,9,"falls asleep"),event(9,4,0,41,"wakes up"),event(8,20,0,0,739),event(3,31,23,53,419),event(10,17,0,58,"wakes up"),event(7,24,0,56,"falls asleep"),event(10,23,0,24,"wakes up"),event(8,18,23,56,1163),event(6,5,0,12,"falls asleep"),event(4,14,0,56,"wakes up"),event(7,14,0,0,2713),event(4,28,0,57,"wakes up"),event(5,7,0,2,1367),event(5,15,0,1,"falls asleep"),event(10,11,23,59,3391),event(10,14,0,38,"falls asleep"),event(6,12,0,17,"falls asleep"),event(5,24,23,59,997),event(11,17,0,53,"wakes up"),event(3,9,0,10,"wakes up"),event(3,28,0,17,"falls asleep"),event(10,30,0,50,"wakes up"),event(2,13,0,35,"falls asleep"),event(9,10,0,54,"wakes up")};

    public static void main(String[] args) {
        Arrays.sort(events, (o1, o2) -> {
            int first = o1.minute + o1.hour * 100 + o1.day * 100 * 100 + o1.month * 100 * 100 * 100;
            int second = o2.minute + o2.hour * 100 + o2.day * 100 * 100 + o2.month * 100 * 100 * 100;
            return first - second;
        });
        int id = 0;
        for (Event e: events) {
            if (e.id > 0) {
                id = e.id;
            } else {
                e.id = id;
            }
        }

        Map<Integer, List<Integer>> guards = new HashMap<>();
        int currentGuard = 0;
        int asleepFrom = 0;
        for (Event e: events) {
            if (!guards.containsKey(e.id)) {
                Integer[] hour = new Integer[60];
                Arrays.fill(hour, 0);
                List<Integer> ts = Arrays.asList(hour);
                guards.put(e.id, ts);
            }

            if (e.type.equals("start")) {
                currentGuard = e.id;
            } else if (e.type.equals("falls asleep")) {
                asleepFrom = e.minute;
            } else if (e.type.equals("wakes up")) {
                int asleepUntil = e.minute;
                for (int i=asleepFrom; i<asleepUntil;i++) {
                    guards.get(e.id).set(i, guards.get(e.id).get(i) + 1);
                }
            }
        }

        int idMostAsleep = 0;
        int mostMinutesMostAsleep = 0;
        int minuteMostAsleepForBestId = 0;
        int countMostAsleepOverall = 0;
        int minutetMostAsleepOverall = 0;
        int guardWithMinuteMostAsleepOverall = 0;
        for (Integer guardId : guards.keySet()) {
            System.out.print(guardId + ":");
            int minutesAsleep = 0;
            int asleepCount = 0;
            int minuteMostAsleep = 0;
            for (int i=0; i< 60; i++) {
                int count = guards.get(guardId).get(i);
                if (asleepCount < count) {
                    asleepCount = count;
                    minuteMostAsleep = i;
                }
                if (countMostAsleepOverall < count) {
                    countMostAsleepOverall = count;
                    guardWithMinuteMostAsleepOverall = guardId;
                    minutetMostAsleepOverall = i;
                }
                minutesAsleep += count;
                System.out.print(guards.get(guardId).get(i)+"|");
            }
            if (mostMinutesMostAsleep < minutesAsleep) {
                mostMinutesMostAsleep = minutesAsleep;
                idMostAsleep = guardId;
                minuteMostAsleepForBestId = minuteMostAsleep;
            }
            System.out.println(" asleep for " + minutesAsleep + " minutes");
        }

        System.out.println("idMostAsleep: "+idMostAsleep+" x minuteMostAsleep: "+minuteMostAsleepForBestId+" = " + (idMostAsleep*minuteMostAsleepForBestId));
        System.out.println("guardWithMinuteMostAsleepOverall: "+guardWithMinuteMostAsleepOverall+" x minuteMostAsleepOverall: "+minutetMostAsleepOverall+" = " + (guardWithMinuteMostAsleepOverall*minutetMostAsleepOverall));
    }

}
