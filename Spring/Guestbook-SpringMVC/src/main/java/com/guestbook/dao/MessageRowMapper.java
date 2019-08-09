package com.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.guestbook.domain.Message;

public class MessageRowMapper implements RowMapper<Message> {
	
	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4)
				);
				
				
		return message;
		
		
	}
	
}
