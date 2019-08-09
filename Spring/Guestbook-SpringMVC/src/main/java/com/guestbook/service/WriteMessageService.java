package com.guestbook.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestbook.dao.MessageDao;
import com.guestbook.dao.MessageJdbcTemplateDao;
import com.guestbook.domain.Message;

@Service("writeService")
public class WriteMessageService implements GuestBookService {

	@Autowired
	private MessageDao dao;
	
	@Autowired
	private MessageJdbcTemplateDao templateDao;
	
	public int write(Message message) {
		
		int rCnt = 0 ;
		
		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행
		
		//Connection conn = null;
		
		//try {
			//conn = ConnectionProvider.getConnection();
						
			//rCnt = dao.insert(conn, message);
			
		rCnt = templateDao.insert(message);
			
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		return rCnt;	
		
	}

}












