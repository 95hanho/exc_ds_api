package me._hanho.ds.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	// JSON 문자열(ex. "["2024-11-29 12:00", "2024-12-09 12:00"]")을 List<Date>로 변환
	public static List<Date> parseScheduleAfterDate(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        objectMapper.setDateFormat(dateFormat);

        // JSON 문자열을 List<Date>로 변환
        List<Date> dateList;
		try {
			dateList = objectMapper.readValue(json, new TypeReference<List<Date>>() {});
		} catch (JsonMappingException e) {
			return null;
		} catch (JsonProcessingException e) {
			return null;
		}
        return dateList;
    }
	
}
