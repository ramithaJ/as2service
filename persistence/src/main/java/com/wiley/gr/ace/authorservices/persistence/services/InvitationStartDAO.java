package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;

public interface InvitationStartDAO {
	
	boolean updateInviteResetPWDLog(String GuId, String Email) throws Exception;
	
	boolean createInvitationLog(InvitationLog invitationLog) throws Exception;
}
