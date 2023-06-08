package com.example.learnflows.data.domain

import androidx.compose.runtime.Stable

@Stable
abstract class DomainModel {
    @Stable
    abstract fun getRecordId(): Any
    @Stable
    abstract fun getParentOneId(): Long
    @Stable
    open fun changeCheckedState(): Boolean = false
    @Stable
    open fun getName(): String = "will be returned any string"
    @Stable
    abstract fun setIsChecked(value: Boolean)
    @Stable
    open fun hasParentOneId(pId: Int): Boolean = false
}