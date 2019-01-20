package com.zipcodewilmington.generic.group;

import com.zipcodewilmington.generic.identifiables.IdentifiableInterface;

import java.io.Serializable;

/**
 * @author leon on 05/12/2018.
 */
abstract public class AbstractGroup<
        TypeOfId extends Serializable,
        TypeOfEntity extends IdentifiableInterface<TypeOfId>>
        implements GroupInterface<TypeOfId, TypeOfEntity> {
}
