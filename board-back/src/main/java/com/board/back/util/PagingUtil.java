package com.board.back.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingUtil {

	Integer currentPageNum;
	
	Integer objectCountTotal;
	Integer objectCountPerPage;
	Integer objectStartNum;
	Integer objectEndNum;
	
	Integer pageNumCountTotal;
	Integer pageNumCountPerPage;
	Integer pageNumStart;
	Integer pageNumEnd;
	
	Boolean isPrev;
	Boolean isNext;
	
	public PagingUtil() {
		this.currentPageNum = 1;
		this.objectCountPerPage = 10;
		this.pageNumCountPerPage = 10;
		
		setObjectStartAndEnd();
	}
	
	public PagingUtil(int currentPageNum) {
		this.currentPageNum = (0 < currentPageNum) ? currentPageNum : 1;
		this.objectCountPerPage = 10;
		this.pageNumCountPerPage = 10;
		
		setObjectStartAndEnd();
	}
	
	public PagingUtil(int currentPageNum, int objectCountPerPage, int pageNumCountPerPage) {
		this.currentPageNum = (0 < currentPageNum) ? currentPageNum : 1;
		this.objectCountPerPage = (0 < objectCountPerPage) ? objectCountPerPage : 10;
		this.pageNumCountPerPage = (0 < pageNumCountPerPage) ? pageNumCountPerPage : 10;
		
		setObjectStartAndEnd();
	}
	
	public void setObjectStartAndEnd() {
		this.objectEndNum = currentPageNum * objectCountPerPage;
		this.objectStartNum = (objectEndNum - 1) - (objectCountPerPage - 1);
	}
	
	public boolean setCalcForPaging(Integer objectCountTotal) {
		if (objectCountTotal == null) {
			return false;
		}
		
		try {
			this.objectCountTotal = objectCountTotal;
			this.pageNumCountTotal = (int) Math.ceil((double)objectCountTotal / objectCountPerPage);
			
			int tmpPageNumStart = ((int) Math.ceil(currentPageNum / pageNumCountPerPage) * pageNumCountPerPage);
			int tmpPageNumEnd = 0;
			
			if (tmpPageNumStart == 0) {
				this.pageNumStart = 1;
				tmpPageNumEnd = tmpPageNumStart + pageNumCountPerPage;
			} else if (tmpPageNumStart == currentPageNum) {
				this.pageNumStart = tmpPageNumStart - (pageNumCountPerPage - 1);
				tmpPageNumEnd = currentPageNum;
			} else {
				this.pageNumStart = pageNumStart + 1;
				tmpPageNumEnd = pageNumStart + pageNumCountPerPage;
			}
			
			this.pageNumEnd = (pageNumCountTotal < tmpPageNumEnd) ? pageNumCountTotal : tmpPageNumEnd;
			
			this.isPrev = (currentPageNum > pageNumCountPerPage) ? true : false;
			this.isNext = (currentPageNum < pageNumCountTotal) ? true : false;
			
			this.objectEndNum = (objectCountTotal < objectEndNum) ? objectCountTotal : objectEndNum;
			return true;
		} catch (Exception e) {e.printStackTrace(); return false;}
	}
	
	public boolean setCalcForPaging() {
		return setCalcForPaging(this.objectCountTotal);
	}
}
