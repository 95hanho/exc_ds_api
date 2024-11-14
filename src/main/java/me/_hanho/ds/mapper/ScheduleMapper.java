package me._hanho.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.Schedule;

@Mapper
public interface ScheduleMapper {

	ArrayList<Schedule> getSchedules();

}
