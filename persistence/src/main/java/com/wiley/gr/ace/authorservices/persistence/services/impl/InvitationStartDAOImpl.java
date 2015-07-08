package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import org.hibernate.Session;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.InvitationStartDAO;

public class InvitationStartDAOImpl implements InvitationStartDAO {

	@Override
	public boolean updateInviteResetPWDLog(String guId, String email)
			throws Exception {
		boolean isUpdated = false;
		Session session = null;
		if (!StringUtils.isEmpty(guId) && !StringUtils.isEmpty(email)) {
			try {
				session = getSessionFactory().openSession();
				String hql = "from InviteResetpwdLog rp whwere rp.emailAddress = :email";
				InviteResetpwdLog inviteResetpwdLog = (InviteResetpwdLog) session
						.createQuery(hql).setString("email", email)
						.uniqueResult();
				session.beginTransaction();
				inviteResetpwdLog.setGuid(guId);
				session.getTransaction().commit();
				isUpdated = true;
			} catch (Exception e) {
				if (!StringUtils.isEmpty(session))
					session.getTransaction().rollback();
			} finally {
				if (!StringUtils.isEmpty(session)) {
					session.flush();
					session.close();
				}
			}
		}
		return isUpdated;
	}

	@Override
	public boolean createInvitationLog(
			InvitationLog invitationLog) throws Exception {
		boolean isUpdated = false;
		Session session = null;
		if (!StringUtils.isEmpty(invitationLog)) {
			try {
				session = getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(invitationLog);
				session.getTransaction().commit();
				isUpdated = true;
			} catch (Exception e) {
				if (!StringUtils.isEmpty(session))
					session.getTransaction().rollback();
			} finally {
				if (!StringUtils.isEmpty(session)) {
					session.flush();
					session.close();
				}
			}
		}
		return isUpdated;
	}
}
