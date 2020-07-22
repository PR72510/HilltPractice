package com.example.hilltpractice.retrofit

import com.example.hilltpractice.models.Blog
import com.example.hilltpractice.utils.EntityMapper
import javax.inject.Inject

/**
 * Created by PR72510 on 22/7/20.
 */
class NetworkMapper @Inject constructor() : EntityMapper<BlogNetworkEntity, Blog> {
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            entity.id,
            entity.title,
            entity.body,
            entity.image,
            entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            domainModel.id,
            domainModel.title,
            domainModel.body,
            domainModel.image,
            domainModel.category
        )
    }

    fun mapFromEntryList(entityList: List<BlogNetworkEntity>): List<Blog> {
        return entityList.map { mapFromEntity(it) }
    }
}