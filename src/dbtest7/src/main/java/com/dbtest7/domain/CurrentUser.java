/*
 * This class represents the current user of the system
 * 
 */

package com.dbtest7.domain;

import javax.persistence.OneToOne;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;


import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
//import org.springframework.roo.addon.activerecord.RooJpaActiveRecord;

@RooJavaBean
@RooToString
//@RooJpaActiveRecord(finders = { "findUsersById" })
public class CurrentUser {
	enum UserType { Noob, Elite };	// Apply constraints depending on user type
	
	java.lang.Long Id;
	
	@Size(max = 200)
	String name;
	
	UserType type;
	
	@OneToOne
	AccessRecord accessRecord;
	
	// Add a file to records - adds a pointer to a database object
	void addRecord(String fileId)
	{
		accessRecord.addFileId(fileId);
	}
	
	// Share a specific file (identified by its Id) with another user
	void shareFile(String fileId, Long otherUserId)
	{
		
		CurrentUser otherUser = new CurrentUser();
		
		/* TODO */
		/* Find user by his user Id, once found, add fileId to other user accessRecord. */
		// Enable next two lines if working with roo 2.1
		//TypedQuery<CurrentUser> userIdQuery = CurrentUser.findUsersById(otherUserId);
		//CurrentUser user = userIdQuery.getSingleResult();
		
		otherUser.addRecord(fileId);
	}

}

