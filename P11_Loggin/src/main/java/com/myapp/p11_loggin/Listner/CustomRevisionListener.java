package com.myapp.p11_loggin.Listner;

import com.myapp.p11_loggin.Entity.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity revision = (CustomRevisionEntity) revisionEntity;

        // Get the operation type based on revision type
        revision.setOperationType(getOperationType(revision));
    }

    private String getOperationType(CustomRevisionEntity revision) {
        // Map the numeric revtype to operation types:
        // revtype 0 -> INSERT
        // revtype 1 -> UPDATE
        // revtype 2 -> DELETE

        if (revision == null) {
            return "UNKNOWN";  // Default value in case of unknown revision
        }

        int revtype = revision.getId(); // This corresponds to the revtype in Envers (0: INSERT, 1: UPDATE, 2: DELETE)

        // Return the corresponding operation string
        switch (revtype) {
            case 0:
                return "INSERT";
            case 1:
                return "UPDATE";
            case 2:
                return "DELETE";
            default:
                return "UNKNOWN";
        }
    }
}