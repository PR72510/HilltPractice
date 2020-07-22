package com.example.hilltpractice.utils

/**
 * Created by PR72510 on 22/7/20.
 */
interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}