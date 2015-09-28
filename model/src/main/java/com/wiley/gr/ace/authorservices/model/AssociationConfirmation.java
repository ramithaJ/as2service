/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class AssociationConfirmation.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AssociationConfirmation {

    /** The task id. */
    private Integer taskId;

    /** The is association confirmed. */
    private boolean isAssociationconfirmed;

    /**
     * Gets the task id.
     *
     * @return the task id
     */
    public final Integer getTaskId() {
        return taskId;
    }

    /**
     * Sets the task id.
     *
     * @param taskId
     *            the new task id
     */
    public final void setTaskId(final Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * Checks if is association confirmed.
     *
     * @return true, if is association confirmed
     */
    public final boolean isAssociationConfirmed() {
        return isAssociationconfirmed;
    }

    /**
     * Sets the association confirmed.
     *
     * @param isAssociationconfirmed
     *            the new association confirmed
     */
    public final void setAssociationConfirmed(
            final boolean isAssociationconfirmed) {
        this.isAssociationconfirmed = isAssociationconfirmed;
    }

}
