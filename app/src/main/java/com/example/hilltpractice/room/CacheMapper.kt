package com.example.hilltpractice.room

import com.example.hilltpractice.models.Blog
import com.example.hilltpractice.utils.EntityMapper
import javax.inject.Inject

/**
 * Created by PR72510 on 22/7/20.
 */
class CacheMapper @Inject constructor() : EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            entity.id, entity.title, entity.body, entity.image, entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            domainModel.id,
            domainModel.title,
            domainModel.body,
            domainModel.category,
            domainModel.image
        )
    }

    fun mapFromEntityList(list: List<BlogCacheEntity>): List<Blog> {
        return list.map { mapFromEntity(it) }
    }
}