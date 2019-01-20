package com.zipcodewilmington.generic.group;

import com.zipcodewilmington.generic.identifiables.IdentifiableInterface;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leon on 06/12/2018.
 */
public class Group<TypeOfId extends Serializable,
        TypeOfEntity extends IdentifiableInterface<TypeOfId>> extends AbstractGroup<TypeOfId, TypeOfEntity>{

    List<TypeOfEntity> group;

    public Group() {
        group = new ArrayList<>();
    }

    @Override
    public Integer count() {
        return group.size();
    }

    @Override
    public void insert(IdentifiableInterface object) {
        group.add((TypeOfEntity) object);
    }

    @Override
    public void delete(IdentifiableInterface object) {
        group.remove(object);

    }

    @Override
    public void delete(Serializable serializable) {
        while (group.iterator().hasNext()) {
            if (group.iterator().next().getIdentity() == serializable) {
                group.remove(group.iterator().next());
            }
        }
    }

    @Override
    public Boolean has(IdentifiableInterface object) {
        return group.contains(object);
    }

    @Override
    public Boolean has(Serializable serializable) {
        for (TypeOfEntity t:group
             ) {
            if (t.getIdentity() == serializable) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TypeOfEntity> filter(Predicate<TypeOfEntity> predicate) {
        return group.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Class getIdentityType() {
        return null;
    }

    @Override
    public Class getIdentifiableType() {
        return null;
    }

}
