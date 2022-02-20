package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.BaseEntity;

public interface CrudService<ENTITY extends BaseEntity> {

    ENTITY create(ENTITY entity);

    ENTITY update(ENTITY entity);

    void delete(Long id);
}
