package com.dbtest7.domain;

import java.awt.List;

public class AccessRecord {
	int totalRecords = 0;
	List files = new List();
	
	public void addFileId(String fileId)
	{
		files.add(fileId);
	}
}
