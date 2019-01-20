package com.zipcodewilmington.generic.identifiables;

import java.io.Serializable;

/**
 * @author leon on 05/12/2018.
 * @ATTENTION_TO_STUDENTS - You are forbidden from modifying this interface
 */
public interface IdentifiableInterface<TypeOfId extends Serializable> {
    TypeOfId getIdentity();
    void setId(TypeOfId id);
    Class<? extends Serializable> getIdentityType();
}
