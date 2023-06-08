package com.example.learnflows.data.domain.manufacturing

import androidx.compose.runtime.Stable
import com.example.learnflows.data.domain.DomainModel

@Stable
data class DomainTeamMember(
    var id: Long,
    var departmentId: Long,
    var department: String,
    var email: String? = null,
    var fullName: String,
    var jobRole: String,
    var roleLevelId: Long,
    var passWord: String? = null,
    var companyId: Long,
    var detailsVisibility: Boolean = false,
    var isSelected: Boolean = false
) : DomainModel() {
    override fun getRecordId() = id
    override fun getParentOneId() = departmentId
    override fun getName() = fullName

    override fun setIsChecked(value: Boolean) {
        isSelected = value
    }
}