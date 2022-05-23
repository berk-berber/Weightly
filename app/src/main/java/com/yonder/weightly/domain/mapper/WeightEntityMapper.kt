package com.yonder.weightly.domain.mapper

import com.yonder.weightly.data.local.WeightEntity
import com.yonder.weightly.domain.uimodel.WeightUIModel
import com.yonder.weightly.ui.home.DATE_FORMAT_CHART
import com.yonder.weightly.utils.extensions.EMPTY
import com.yonder.weightly.utils.extensions.orZero
import com.yonder.weightly.utils.extensions.toFormat
import java.util.*

object WeightEntityMapper {

    fun map(entity: WeightEntity?): WeightUIModel? {
        if (entity == null)
            return null
        val date = entity.timestamp ?: Date()
        return WeightUIModel(
            uid = entity.uid.orZero,
            value = entity.value.orZero(),
            valueText = if (entity.value != null) {
                entity.value.toString()
            } else {
                String.EMPTY
            },
            emoji = entity.emoji.orEmpty(),
            note = entity.note.orEmpty(),
            date = date,
            formattedDate = date.toFormat(DATE_FORMAT_CHART)
        )
    }
}