package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;
import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Service("listServcie")
public class MemberListService implements MemberService {

	//@Autowired
	//private MemberDao dao;
	
	@Autowired
	private MemberJdbcTemplateDao dao;
	
	final int MEMBER_CNT_List = 3;
	
	public ListViewData getListData(
			int currentPageNumber, 
			SearchParam searchParam) {
		
		ListViewData listData = new ListViewData();
		

			// 현재 페이지 번호
			listData.setCurrentPageNumber(currentPageNumber);
			
			// 전체 게시물의 개수
			int totalCnt = dao.selectTotalCount(searchParam);
			
			int totalPageCnt = 0;
			// 전체 페이지 개수
			if(totalCnt>0) {
				totalPageCnt = totalCnt/MEMBER_CNT_List;
				if(totalCnt%MEMBER_CNT_List>0) {
					totalPageCnt++;
				}
			}
			listData.setPageTotalCount(totalPageCnt);
			
			
			// 구간 검색을 위한 index
			// 1 -> 0 , 2 -> 3, 3 -> 6, 4 -> 9
			int index = (currentPageNumber-1)*MEMBER_CNT_List;
			
			
			// 회원 정보 리스트 
			List<MemberInfo> memberList = null;
			// 1. 검색 조건이 없는경우  selectList -> 전체 회원의 리스트
			// 2. id 로 검색 : where  like uid '%?%'
			// 3. name 으로 검색 : where like uname '%?%'
			// 4. id 또는 name :  where like uname '%?%' or like uid '%?%'
//			
//			if(searchParam != null) {
//				switch (searchParam.getStype()) {
//					case "both":
//						memberList = dao.selectListByBoth(conn, index, MEMBER_CNT_List, searchParam);
//					break;
//					case "id":
//						memberList = dao.selectListById(conn, index, MEMBER_CNT_List, searchParam);
//					break;
//					case "name":
//						memberList = dao.selectListByName(conn, index, MEMBER_CNT_List, searchParam);
//					break;
//				}
//			} else {
//				memberList = dao.selectList(conn, index, MEMBER_CNT_List);
//			}
//			
			if(searchParam == null) {
				
				memberList = dao.selectList(index, MEMBER_CNT_List);
			
			} else if(searchParam.getStype().equals("both")) {
				
				memberList = dao.selectListByBoth(index, MEMBER_CNT_List, searchParam);
			
			} else if(searchParam.getStype().equals("id")) {
				
				memberList = dao.selectListById(index, MEMBER_CNT_List, searchParam);
			
			} else if(searchParam.getStype().equals("name")) {
				
				memberList = dao.selectListByName(index, MEMBER_CNT_List, searchParam);
			}
			
			
			listData.setMemberList(memberList);
			
			// 1 -> 9-0 =9, 2 -> 9-3=6
			int no = totalCnt - index;
			listData.setNo(no);
			
			listData.setTotalCount(totalCnt);
			

		
		return listData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
