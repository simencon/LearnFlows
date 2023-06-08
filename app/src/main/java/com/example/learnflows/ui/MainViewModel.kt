package com.example.learnflows.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnflows.data.TransformationsToDomain.changeDetails
import com.example.learnflows.data.domain.manufacturing.DomainTeamMember
import com.example.learnflows.repositories.ManufacturingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import javax.inject.Inject

@JvmInline
value class CurrentMember(val id: Long)

val NoCurrentMember = CurrentMember(-1L)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ManufacturingRepository
) : ViewModel() {
    val isLoadingInProgress = MutableLiveData(false)
    val isNetworkError = MutableLiveData(false)

    fun onNetworkErrorShown() {
        isLoadingInProgress.value = false
        isNetworkError.value = false
    }

    fun insertTeamMember(teamMember: DomainTeamMember) = viewModelScope.launch {
        repository.insertTeamMember(teamMember)
    }

    fun deleteTeamMember(teamMember: DomainTeamMember) = viewModelScope.launch {
        repository.deleteTeamMember(teamMember)
    }

    fun updateTeamMember(teamMember: DomainTeamMember) = viewModelScope.launch {
        repository.deleteTeamMember(teamMember)
    }

    private val _currentMember = MutableStateFlow(NoCurrentMember)

    private val _teamF = repository.teamComplete()

    @OptIn(ExperimentalCoroutinesApi::class)
    val teamSF: Flow<List<DomainTeamMember>> = _currentMember.flatMapLatest { currentMember ->
        _teamF.map {
            it.changeDetails(currentMember.id)
        }
    }

    fun changeCurrentTeamMember(id: Long) {
        _currentMember.value = CurrentMember(id)
    }

    fun syncTeam() {
//        ToDo add some function to play with Flows
        viewModelScope.launch {
            isLoadingInProgress.value = true
            isLoadingInProgress.value = false
            isNetworkError.value = true
        }
    }
}