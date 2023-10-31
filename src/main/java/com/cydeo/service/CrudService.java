package com.cydeo.service;

import java.util.List;
public interface CrudService<T, ID> { //T-->Object Type and ID--> Unique Identifier
    T save(T object); //save object return object
    List<T>findAll(); //does not accept any parameters but return list of object
    T findById(ID id); //accepting id and returning object

    void deleteById(ID id);//accepting id nothing returning
    void update(T object);
}
