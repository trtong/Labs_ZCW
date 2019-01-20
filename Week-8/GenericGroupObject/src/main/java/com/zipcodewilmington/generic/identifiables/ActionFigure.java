package com.zipcodewilmington.generic.identifiables;

import java.io.Serializable;

/**
 * @author leon on 05/12/2018.
 */
public class ActionFigure<TypeOfId extends Serializable> implements IdentifiableInterface<TypeOfId> {
    private TypeOfId id;

    public void setId(TypeOfId id) {
        this.id = id;
    }

    public TypeOfId getIdentity() {
        return id;
    }


    public Class<? extends Serializable> getIdentityType() {
        return id.getClass();
    }
}
