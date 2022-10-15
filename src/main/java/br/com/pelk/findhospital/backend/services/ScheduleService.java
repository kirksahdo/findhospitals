package br.com.pelk.findhospital.backend.services;

import br.com.pelk.findhospital.backend.serialization.ScheduleSerialization;
import br.com.pelk.findhospital.exceptions.ScheduleNotFoundException;
import br.com.pelk.findhospital.models.Schedule;
import java.util.ArrayList;

public final class ScheduleService {
    public static void createSchedule(Schedule schedule) {
        ScheduleSerialization.writeFile(schedule);
    }
    
    public static Schedule getSchedule(String id) throws ScheduleNotFoundException {
        Schedule schedule;
        ArrayList<Schedule> schedules = ScheduleSerialization.readFile();
        for(Schedule u : schedules) { 
            if (u.getId().equalsIgnoreCase(id)) { 
                return u;
            }
        }
        throw new ScheduleNotFoundException();
    }
    
    public static ArrayList<Schedule> getSchedules() {
        return ScheduleSerialization.readFile();
    }
    
    public static void deleteSchedule(Schedule schedule) throws ScheduleNotFoundException {
        ArrayList<Schedule> schedules = ScheduleSerialization.readFile();
        
        for(Schedule u : schedules) { 
            if(u.getId().equalsIgnoreCase(schedule.getId())) { 
                schedules.remove(schedule);
                return;
            }
        }
        throw new ScheduleNotFoundException();
    }
    
    public static void editSchedule(Schedule schedule) throws ScheduleNotFoundException { 
        ArrayList<Schedule> schedules = ScheduleSerialization.readFile();
        
        for(Schedule u : schedules) { 
            if(u.getId().equalsIgnoreCase(schedule.getId())) { 
                schedules.remove(u);
                schedules.add(schedule);
                ScheduleSerialization.writeFile(schedules);
                return;
            }
        }
        throw new ScheduleNotFoundException();
    }
}
